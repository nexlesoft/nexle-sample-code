package com.core.utilities;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import org.apache.log4j.Logger;

public class MySQL {
	
	private final static Logger logger = Logger.getLogger(MySQL.class.getName());
    
    /**
     * Get JDBC driver configuration status
     * @return boolean
     */
    public static boolean checkJDBCConfig() {
                
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("JDBC driver is not configured correctly");
        }        
    }
    
    /**
     * Connect to MySQL database
     * @return Connection object
     */
    public static Connection connectToDB() {
        
        boolean 	config = checkJDBCConfig();
        String 		username = KeyValue.getDatabaseProperty("Username");
        String 		password = KeyValue.getDatabaseProperty("Password");
        String 		schema = KeyValue.getDatabaseProperty("Schema");
        String 		ip = KeyValue.getDatabaseProperty("IP");
        String 		port = KeyValue.getDatabaseProperty("Port");
        Connection 	connection = null;
        
        if (password.isEmpty()) {
            password = null;
        }
        
        if (config != false) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + schema, username,
                        password); 
            } catch (SQLException e) {
                e.printStackTrace();
                try {
                    throw e;
                } catch (SQLException f) {
                    f.printStackTrace();
                }
            }
           
            if (connection != null) {                
                try {
                    if (getMaxAllowedPacket(connection) < Integer.parseInt(KeyValue.getDatabaseProperty("MaxAllowedPacket"))) {
                        setMaxAllowedPacket(KeyValue.getDatabaseProperty("MaxAllowedPacket"), connection);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else {}
        }
        return connection;
    }
    
    /**
     * Get the MaxAllowedPacket property from MySQL
     * @param 	dbConnection Connection object
     * @return 	Value of the MaxAllowedPacket property
     */
    public static int getMaxAllowedPacket(Connection connection) throws SQLException {
        
        int 				value = 0;
        PreparedStatement 	statement = null;
        ResultSet 			result = null;
        String 				sqlGetMaxAllowedPacket = "show variables where variable_name = 'max_allowed_packet'";
        
        try {
            if (connection != null) {
            	statement = connection.prepareStatement(sqlGetMaxAllowedPacket);
            	result = statement.executeQuery(sqlGetMaxAllowedPacket);
            }
            if (result.next()) {
                value = Integer.parseInt(result.getString(2));
                logger.debug("Retrieved MaxAllowedPacket from MysQL. Value=" + value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception f) {
            f.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                	statement.close();
                }
            } catch (SQLException g) {
            }
        }
        result.close();
        return value;
    }
    
    /**
     * Set MaxAllowedPacket property for MySQL
     * @param 	val Value to set the property to
     * @param 	dbConnection Connection object
     */
    public static void setMaxAllowedPacket(String value, Connection connection) throws SQLException {
        
        PreparedStatement 	statement = null;
        String 				sqlSetMaxAllowedPacket = "set global max_allowed_packet = " + value;
        
        try {
            if (connection != null) {
            	statement = connection.prepareStatement(sqlSetMaxAllowedPacket);
            	statement.executeQuery(sqlSetMaxAllowedPacket);
                logger.debug("Setting MaxAllowedPacket in MysQL. Value=" + value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception f) {
            f.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                	statement.close();
                }  
            } catch (SQLException g) {
            } 
        }
    }
    
    /**
     * Insert result step into test results table
     * @param 	val Value to set the property to
     * @param 	dbConnection Connection object
     */
    public static void insertTestStepIntoResultTable(String action, String detail, String message) throws SQLException {
        
        Connection 			connection = connectToDB();
        PreparedStatement 	statement = null;
        String 				sqlInsertTestStep = "";
        String 				currentTable = "Results";

        if(action.toUpperCase().equals("START")) {
        	sqlInsertTestStep = "INSERT INTO " + currentTable + " (activity) " + "VALUES('" + action.toUpperCase() + "')";
        } else if(action.toUpperCase().equals("END")) {
        	sqlInsertTestStep = "INSERT INTO " + currentTable + " (activity) " + "VALUES('" + action.toUpperCase() + "')";
        } else {
        	sqlInsertTestStep = "INSERT INTO " + currentTable + " (activity, detail, message) " + "VALUES('" + action + "'," + "'" + detail + "'," + "'" + message + "')";
        }
        
        try {
            if (connection != null) {
            	statement = connection.prepareStatement(sqlInsertTestStep);
            	statement.executeUpdate(sqlInsertTestStep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception f) {
            f.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                	statement.close();
                }  
            } catch (SQLException g) {
            } 
        }
    }
    
    /**
     * Get MaxID from POC_Demo table for testing purposes
     */
    public static int getMaxRunIDFromPOCDemo() throws SQLException {
        
        Connection 			connection = connectToDB();
        PreparedStatement 	statement = null;
        String 				currentTable = "google_home";
        String 				sqlGetMaxIDFromCurrentTable = "SELECT max(id) FROM " + currentTable;
        ResultSet 			result = null;
        int 				foundID = 0;

        try {
            if (connection != null) {
                statement = connection.prepareStatement(sqlGetMaxIDFromCurrentTable);
                result = statement.executeQuery(sqlGetMaxIDFromCurrentTable);
	            if (result.next()) {
	            	foundID = Integer.parseInt(result.getObject(1).toString());
	                logger.debug("Retrieved max id of: " + foundID);
	            }
            }
        } catch (SQLException d) {
            d.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if (statement != null) {
            		statement.close();  	
            	}
            } catch (SQLException f) {
            }            
        }
        result.close();
        statement.close();
        connection.close();
       
        return foundID;
    }
    
    /**
     * Get object method associated with a particular page and object name
     */
    public static String getObjectMethodFromPage(String page, String objectName) throws SQLException {
        
        Connection 			connection = connectToDB();
        PreparedStatement 	statement = null;
        String 				sqlGetObjectMethodFromCurrentTable = "SELECT object_method FROM " + page + " WHERE object_name = '" + objectName + "'";
        ResultSet 			result = null;
        String 				foundMethod = "";
        
        try {
            if (connection != null) {
                statement = connection.prepareStatement(sqlGetObjectMethodFromCurrentTable);
                result = statement.executeQuery(sqlGetObjectMethodFromCurrentTable);
	            if (result.next()) {
	            	foundMethod = result.getObject(1).toString();
	                logger.debug("Retrieved object method: " + foundMethod);
	            }
            }
        } catch (SQLException d) {
            d.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if (statement != null) {
            		statement.close();  	
            	}
            } catch (SQLException f) {
            }            
        }
        result.close();
        statement.close();
        connection.close();
       
        return foundMethod;
    }
    
    /**
     * Get object method value associated with a particular page and object name
     */
    public static String getObjectMethodDetailFromPage(String page, String objectName) throws SQLException {
        
        Connection 			connection = connectToDB();
        PreparedStatement 	statement = null;
        String 				sqlGetObjectMethodDetailFromCurrentTable = "SELECT object_method_value FROM " + page + " WHERE object_name = '" + objectName + "'";
        ResultSet 			result = null;
        String 				foundMethodValue = "";

        try {
            if (connection != null) {
                statement = connection.prepareStatement(sqlGetObjectMethodDetailFromCurrentTable);
                result = statement.executeQuery(sqlGetObjectMethodDetailFromCurrentTable);
	            if (result.next()) {
	            	foundMethodValue = result.getObject(1).toString();
	                logger.debug("Retrieved method value of: " + foundMethodValue);
	            }
            }
        } catch (SQLException d) {
            d.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if (statement != null) {
            		statement.close();  	
            	}
            } catch (SQLException f) {
            }            
        }
        result.close();
        statement.close();
        connection.close();
       
        return foundMethodValue;
    }
    
    /**
     * Get object type associated with a particular page and object name
     */
    public static String getObjectTypeFromPage(String page, String objectName) throws SQLException {
        
        Connection 			connection = connectToDB();
        PreparedStatement 	statement = null;
        String 				sqlGetObjectTypeFromCurrentTable = "SELECT object_type FROM " + page + " WHERE object_name = '" + objectName + "'";
        ResultSet 			result = null;
        String 				foundType = "";

        try {
            if (connection != null) {
                statement = connection.prepareStatement(sqlGetObjectTypeFromCurrentTable);
                result = statement.executeQuery(sqlGetObjectTypeFromCurrentTable);
	            if (result.next()) {
	            	foundType = result.getObject(1).toString();
	                logger.debug("Retrieved object type of: " + foundType);
	            }
            }
        } catch (SQLException d) {
            d.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if (statement != null) {
            		statement.close();  	
            	}
            } catch (SQLException f) {
            }            
        }
        result.close();
        statement.close();
        connection.close();
       
        return foundType;
    }
    
    /**
     * Get action method associated with a particular action
     */
    public static String getActionMethodFromActionsTable(String actionName) throws SQLException {
        
        Connection 			connection = connectToDB();
        PreparedStatement 	statement = null;
        String 				sqlGetActionMethodFromCurrentTable = "SELECT action_method FROM actions WHERE action_name = '" + actionName + "'";
        ResultSet 			result = null;
        String 				foundActionMethod = "";

        try {
            if (connection != null) {
                statement = connection.prepareStatement(sqlGetActionMethodFromCurrentTable);
                result = statement.executeQuery(sqlGetActionMethodFromCurrentTable);
	            if (result.next()) {
	            	foundActionMethod = result.getObject(1).toString();
	                logger.debug("Retrieved action name of: " + foundActionMethod);
	            }
            }
        } catch (SQLException d) {
            d.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if (statement != null) {
            		statement.close();  	
            	}
            } catch (SQLException f) {
            }            
        }
        result.close();
        statement.close();
        connection.close();
       
        return foundActionMethod;
    }
    
    /**
     * Get action page associated with a particular action
     */
    public static String getActionPageFromActionsTable(String actionName) throws SQLException {
        
        Connection 			connection = connectToDB();
        PreparedStatement 	statement = null;
        String 				sqlGetActionPageFromCurrentTable = "SELECT action_page FROM actions WHERE action_name = '" + actionName + "'";
        ResultSet 			result = null;
        String 				foundActionPage = "";

        try {
            if (connection != null) {
                statement = connection.prepareStatement(sqlGetActionPageFromCurrentTable);
                result = statement.executeQuery(sqlGetActionPageFromCurrentTable);
	            if (result.next()) {
	            	foundActionPage = result.getObject(1).toString();
	                logger.debug("Retrieved action page value of: " + foundActionPage);
	            }
            }
        } catch (SQLException d) {
            d.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if (statement != null) {
            		statement.close();  	
            	}
            } catch (SQLException f) {
            }            
        }
        result.close();
        statement.close();
        connection.close();
       
        return foundActionPage;
    }
    
    /**
     * Get action object associated with a particular action
     */
    public static String getActionObjectFromActionsTable(String actionName) throws SQLException {
        
        Connection 			connection = connectToDB();
        PreparedStatement 	statement = null;
        String 				sqlGetActionObjectFromCurrentTable = "SELECT action_object FROM actions WHERE action_name = '" + actionName + "'";
        ResultSet 			result = null;
        String 				foundActionObject = "";

        try {
            if (connection != null) {
                statement = connection.prepareStatement(sqlGetActionObjectFromCurrentTable);
                result = statement.executeQuery(sqlGetActionObjectFromCurrentTable);
	            if (result.next()) {
	            	foundActionObject = result.getObject(1).toString();
	                logger.debug("Retrieved action object value of: " + foundActionObject);
	            }
            }
        } catch (SQLException d) {
            d.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if (statement != null) {
            		statement.close();  	
            	}
            } catch (SQLException f) {
            }            
        }
        result.close();
        statement.close();
        connection.close();
       
        return foundActionObject;
    }
    
    /**
     * Get number of test steps from POC_Demo table for testing purposes
     */
    public static int getNumberOfStepsFromTestTable() throws SQLException {
        
        Connection 			connection = connectToDB();
        PreparedStatement 	statement = null;
        String 				currentTable = "POC_demo";
        String 				sqlGetMaxIDFromCurrentTable = "SELECT COUNT(*) AS id FROM " + currentTable;
        ResultSet 			result = null;
        int 				foundCount = 0;

        try {
            if (connection != null) {
                statement = connection.prepareStatement(sqlGetMaxIDFromCurrentTable);
                result = statement.executeQuery(sqlGetMaxIDFromCurrentTable);
	            if (result.next()) {
	            	foundCount = Integer.parseInt(result.getObject(1).toString());
	                logger.debug("Retrieved count of: " + foundCount);
	            }
            }
        } catch (SQLException d) {
            d.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if (statement != null) {
            		statement.close();  	
            	}
            } catch (SQLException f) {
            }            
        }
        result.close();
        statement.close();
        connection.close();
       
        return foundCount;
    }
    
    /**
     * Get an action input data from test table based upon the passed in id
     */
    public static String getActionDataFromTestTable(int id) throws SQLException {
        
        Connection 			connection = connectToDB();
        PreparedStatement 	statement = null;
        String 				currentTable = "POC_Demo";
        String 				sqlGetActionNameFromCurrentTable = "SELECT action_data FROM " + currentTable + " WHERE id = '" + id + "'";
        ResultSet 			result = null;
        String 				actionData = "";

        try {
            if (connection != null) {
                statement = connection.prepareStatement(sqlGetActionNameFromCurrentTable);
                result = statement.executeQuery(sqlGetActionNameFromCurrentTable);

                if (result.next()) {
                	actionData = result.getObject(1).toString();
	                logger.debug("Retrieved test data value of: " + actionData);
	            }
            }
        } catch (SQLException d) {
            d.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if (statement != null) {
            		statement.close();  	
            	}
            } catch (SQLException f) {
            }            
        }
        result.close();
        statement.close();
        connection.close();
       
        return actionData;
    }
    
    /**
     * Get an action_name from the test table based upon the passed in id
     */
    public static String getActionNameFromTestTable(int id) throws SQLException {
        
        Connection 			connection = connectToDB();
        PreparedStatement 	statement = null;
        String 				currentTable = "POC_Demo";
        String 				sqlGetActionNameFromCurrentTable = "SELECT action_name FROM " + currentTable + " WHERE id = '" + id + "'";
        ResultSet 			result = null;
        String 				actionName = "";

        try {
            if (connection != null) {
                statement = connection.prepareStatement(sqlGetActionNameFromCurrentTable);
                result = statement.executeQuery(sqlGetActionNameFromCurrentTable);

                if (result.next()) {
	            	actionName = result.getObject(1).toString();
	                logger.debug("Retrieved action_name of: " + actionName);
	            }
            }
        } catch (SQLException d) {
            d.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if (statement != null) {
            		statement.close();  	
            	}
            } catch (SQLException f) {
            }            
        }
        result.close();
        statement.close();
        connection.close();
       
        return actionName;
    }
    
    /**
     * Serialize an image file into MySQL
     */
     static void serializeImage(File image) throws ParseException, FileNotFoundException {
        
//		Connection 			connection = connectToDB();
//		FileInputStream 	stream = null;
//		PreparedStatement 	preparedStatement = null;
//		String 				currentTest = KeyValue.getGeneralProperty("CurrentTest");
//		String 				table = KeyValue.getDatabaseProperty("ResultTable");
//		String 				currentRun = KeyValue.getDatabaseProperty("CurrentRun");
//		 
//		try {  
//		    if (connection != null) {
//		        stream = new FileInputStream(image);
//		        preparedStatement = connection.prepareStatement("UPDATE " + table + " SET image=? " + "WHERE runid='" + currentRun + "' AND test ='" + currentTest + "'");
//		        preparedStatement.setBinaryStream(1, stream, (int) image.length());
//		        preparedStatement.executeUpdate();
//		        preparedStatement.close();
//		        connection.close();	
//		    }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    } catch (Exception f) {
//	        f.printStackTrace();
//	    } finally {
//	        try {
//	            if (preparedStatement != null) {
//	            	preparedStatement.close();	
//	            }
//	        } catch (SQLException g) {
//	        }
//
//	        try {
//	            if (connection != null) {
//	            	connection.close();	
//	            }		            
//	        } catch (SQLException h) {
//	            h.printStackTrace(); 
//	        }
//	    }		    
    }
}