package com.core.utilities;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class XMLReader {
	
    private final static Logger 	logger = Logger.getLogger(XMLReader.class.getName());
    String 							targetClass;
    String 							targetTest;
    
    public XMLReader(String className) {
    	targetClass = className;
    	targetTest  = KeyValue.getGeneralProperty("CurrentTestName");
    }
    
    /**
     * Get the value of a child attribute belonging to a parent element associated with the
     * referring class and test name
     * @param attribute Value to get
     * @return The attribute's value
     */
    public String getValue(String attribute) {
    	
    	try {
	    	String 					path = KeyValue.getGeneralProperty("DataFilePath");
	    	File 					inputFile = new File(path);
	        DocumentBuilderFactory 	dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder 		dBuilder = dbFactory.newDocumentBuilder();
	        Document 				doc = dBuilder.parse(inputFile);
	        
	        doc.getDocumentElement().normalize();
	        
	        NodeList 				nodeList = doc.getElementsByTagName("test");
	        String					result = "";
	        
	        for (int i = 0; i < nodeList.getLength(); i++) {
	        	 Node node = nodeList.item(i);
	        	
	             if(node.getNodeType() == Node.ELEMENT_NODE) {
	            	 Element element = (Element) node;
	            	 
	            	 if(element.getAttribute("classname").equalsIgnoreCase(targetClass) && element.getAttribute("testname").equalsIgnoreCase(targetTest)) {
	                	 NodeList childList = element.getElementsByTagName("parameter");
	                	 
	                	 for(int j = 0; j < childList.getLength(); j++) {
	                		 Element childElement = (Element) childList.item(j);
	                		 if(childElement.getAttribute("name").equalsIgnoreCase(attribute)) {
	                			 result = childElement.getTextContent();
	                			 logger.debug("Returning value from xml. Attribute=" + attribute + ", value=" +result);
	                			 break;
	                		 }
	                	 }
	                 }                    
	             }
	        }
	        
	        if(result.length() < 1) {
   			 logger.debug("Unable to retrieve value from xml. Attribute=" + attribute + ", value=" +result);
	            throw new RuntimeException("Unable to access xml attribute: " + attribute);
	        } else {
		        return result;
	        }

    	} catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to access xml file or test data within the xml file. Is there an entry for the test class and test name?");
    	}
        
    } 
    
    
 public String getValue_TestDataSetup(String attribute) {
    	
    	try {
    		
	    	String 					path = KeyValue.getGeneralProperty("TestDataSetupFilePath");
	    	File 					inputFile = new File(path);
	        DocumentBuilderFactory 	dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder 		dBuilder = dbFactory.newDocumentBuilder();
	        Document 				doc = dBuilder.parse(inputFile);
	        
	        doc.getDocumentElement().normalize();
	        
	        NodeList 				nodeList = doc.getElementsByTagName("test");
	        String					result = "";
	        
	        for (int i = 0; i < nodeList.getLength(); i++) {
	        	 Node node = nodeList.item(i);
	        	
	             if(node.getNodeType() == Node.ELEMENT_NODE) {
	            	 Element element = (Element) node;
	            	 
	            	 if(element.getAttribute("classname").equalsIgnoreCase(targetClass) && element.getAttribute("testname").equalsIgnoreCase(targetTest)) {
	                	 NodeList childList = element.getElementsByTagName("parameter");
	                	 
	                	 for(int j = 0; j < childList.getLength(); j++) {
	                		 Element childElement = (Element) childList.item(j);
	                		 if(childElement.getAttribute("name").equalsIgnoreCase(attribute)) {
	                			 result = childElement.getTextContent();
	                			 logger.debug("Returning value from xml. Attribute=" + attribute + ", value=" +result);
	                			 break;
	                		 }
	                	 }
	                 }                    
	             }
	        }
	        
	        if(result.length() < 1) {
   			 logger.debug("Unable to retrieve value from xml. Attribute=" + attribute + ", value=" +result);
	            throw new RuntimeException("Unable to access xml attribute: " + attribute);
	        } else {
		        return result;
	        }

    	} catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to access xml file or test data within the xml file. Is there an entry for the test class and test name?");
    	}
        
    } 


public String getValue_FSPTestDataSetup(String attribute) {
	
	try {
		
    	//String 					path = KeyValue.getGeneralProperty("FSPTestDataFilePath");
		String 					path = KeyValue.getGeneralProperty("FSPTestDataFilePath","FSP");
    	File 					inputFile = new File(path);
        DocumentBuilderFactory 	dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder 		dBuilder = dbFactory.newDocumentBuilder();
        Document 				doc = dBuilder.parse(inputFile);
        
        doc.getDocumentElement().normalize();
        
        NodeList 				nodeList = doc.getElementsByTagName("test");
        String					result = "";
        
        for (int i = 0; i < nodeList.getLength(); i++) {
        	 Node node = nodeList.item(i);
        	
             if(node.getNodeType() == Node.ELEMENT_NODE) {
            	 Element element = (Element) node;
            	 
            	 if(element.getAttribute("classname").equalsIgnoreCase(targetClass) && element.getAttribute("testname").equalsIgnoreCase(targetTest)) {
                	 NodeList childList = element.getElementsByTagName("parameter");
                	 
                	 for(int j = 0; j < childList.getLength(); j++) {
                		 Element childElement = (Element) childList.item(j);
                		 if(childElement.getAttribute("name").equalsIgnoreCase(attribute)) {
                			 result = childElement.getTextContent();
                			 logger.debug("Returning value from xml. Attribute=" + attribute + ", value=" +result);
                			 break;
                		 }
                	 }
                 }                    
             }
        }
        
        if(result.length() < 1) {
			 logger.debug("Unable to retrieve value from xml. Attribute=" + attribute + ", value=" +result);
            throw new RuntimeException("Unable to access xml attribute: " + attribute);
        } else {
	        return result;
        }

	} catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Unable to access xml file or test data within the xml file. Is there an entry for the test class and test name?");
	}
    
}

public String getValue_OSTMemberRegTestDataSetup(String attribute) {
	
	try {
		
		String 					path = KeyValue.getGeneralProperty("OSTMemberRegTestDataFilePath");
    	File 					inputFile = new File(path);
        DocumentBuilderFactory 	dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder 		dBuilder = dbFactory.newDocumentBuilder();
        Document 				doc = dBuilder.parse(inputFile);
        
        doc.getDocumentElement().normalize();
        
        NodeList 				nodeList = doc.getElementsByTagName("test");
        String					result = "";
        
        for (int i = 0; i < nodeList.getLength(); i++) {
        	 Node node = nodeList.item(i);
        	
             if(node.getNodeType() == Node.ELEMENT_NODE) {
            	 Element element = (Element) node;
            	 
            	 if(element.getAttribute("classname").equalsIgnoreCase(targetClass) && element.getAttribute("testname").equalsIgnoreCase(targetTest)) {
                	 NodeList childList = element.getElementsByTagName("parameter");
                	 
                	 for(int j = 0; j < childList.getLength(); j++) {
                		 Element childElement = (Element) childList.item(j);
                		 if(childElement.getAttribute("name").equalsIgnoreCase(attribute)) {
                			 result = childElement.getTextContent();
                			 logger.debug("Returning value from xml. Attribute=" + attribute + ", value=" +result);
                			 break;
                		 }
                	 }
                 }                    
             }
        }
        
        if(result.length() < 1) {
			 logger.debug("Unable to retrieve value from xml. Attribute=" + attribute + ", value=" +result);
            throw new RuntimeException("Unable to access xml attribute: " + attribute);
        } else {
	        return result;
        }

	} catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Unable to access xml file or test data within the xml file. Is there an entry for the test class and test name?");
	}
    
}

public String getValue_EventdesqTestData(String attribute) {
	
	try {
		
    	String 					path = KeyValue.getGeneralProperty("EventdesqTestDataFilePath","OST");
    	File 					inputFile = new File(path);
        DocumentBuilderFactory 	dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder 		dBuilder = dbFactory.newDocumentBuilder();
        Document 				doc = dBuilder.parse(inputFile);
        
        doc.getDocumentElement().normalize();
        
        NodeList 				nodeList = doc.getElementsByTagName("test");
        String					result = "";
        
        for (int i = 0; i < nodeList.getLength(); i++) {
        	 Node node = nodeList.item(i);
        	
             if(node.getNodeType() == Node.ELEMENT_NODE) {
            	 Element element = (Element) node;
            	 
            	 if(element.getAttribute("classname").equalsIgnoreCase(targetClass) && element.getAttribute("testname").equalsIgnoreCase(targetTest)) {
                	 NodeList childList = element.getElementsByTagName("parameter");
                	 
                	 for(int j = 0; j < childList.getLength(); j++) {
                		 Element childElement = (Element) childList.item(j);
                		 if(childElement.getAttribute("name").equalsIgnoreCase(attribute)) {
                			 result = childElement.getTextContent();
                			 logger.debug("Returning value from xml. Attribute=" + attribute + ", value=" +result);
                			 break;
                		 }
                	 }
                 }                    
             }
        }
        
        if(result.length() < 1) {
			 logger.debug("Unable to retrieve value from xml. Attribute=" + attribute + ", value=" +result);
            throw new RuntimeException("Unable to access xml attribute: " + attribute);
        } else {
	        return result;
        }

	} catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Unable to access xml file or test data within the xml file. Is there an entry for the test class and test name?");
	}
    
} 

public String getValue_ShopdesqTestData(String attribute) {
	
	try {
		
    	String 					path = KeyValue.getGeneralProperty("ShopdesqTestDataFilePath","OST");
    	File 					inputFile = new File(path);
        DocumentBuilderFactory 	dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder 		dBuilder = dbFactory.newDocumentBuilder();
        Document 				doc = dBuilder.parse(inputFile);
        
        doc.getDocumentElement().normalize();
        
        NodeList 				nodeList = doc.getElementsByTagName("test");
        String					result = "";
        
        for (int i = 0; i < nodeList.getLength(); i++) {
        	 Node node = nodeList.item(i);
        	
             if(node.getNodeType() == Node.ELEMENT_NODE) {
            	 Element element = (Element) node;
            	 
            	 if(element.getAttribute("classname").equalsIgnoreCase(targetClass) && element.getAttribute("testname").equalsIgnoreCase(targetTest)) {
                	 NodeList childList = element.getElementsByTagName("parameter");
                	 
                	 for(int j = 0; j < childList.getLength(); j++) {
                		 Element childElement = (Element) childList.item(j);
                		 if(childElement.getAttribute("name").equalsIgnoreCase(attribute)) {
                			 result = childElement.getTextContent();
                			 logger.debug("Returning value from xml. Attribute=" + attribute + ", value=" +result);
                			 break;
                		 }
                	 }
                 }                    
             }
        }
        
        if(result.length() < 1) {
			 logger.debug("Unable to retrieve value from xml. Attribute=" + attribute + ", value=" +result);
            throw new RuntimeException("Unable to access xml attribute: " + attribute);
        } else {
	        return result;
        }

	} catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Unable to access xml file or test data within the xml file. Is there an entry for the test class and test name?");
	}
    
} 

public String getValue_MemberdesqTestData(String attribute) {
	
	try {
		
    	String 					path = KeyValue.getGeneralProperty("MemberdesqTestDataFilePath","OST");
    	File 					inputFile = new File(path);
        DocumentBuilderFactory 	dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder 		dBuilder = dbFactory.newDocumentBuilder();
        Document 				doc = dBuilder.parse(inputFile);
        
        doc.getDocumentElement().normalize();
        
        NodeList 				nodeList = doc.getElementsByTagName("test");
        String					result = "";
        
        for (int i = 0; i < nodeList.getLength(); i++) {
        	 Node node = nodeList.item(i);
        	
             if(node.getNodeType() == Node.ELEMENT_NODE) {
            	 Element element = (Element) node;
            	 
            	 if(element.getAttribute("classname").equalsIgnoreCase(targetClass) && element.getAttribute("testname").equalsIgnoreCase(targetTest)) {
                	 NodeList childList = element.getElementsByTagName("parameter");
                	 
                	 for(int j = 0; j < childList.getLength(); j++) {
                		 Element childElement = (Element) childList.item(j);
                		 if(childElement.getAttribute("name").equalsIgnoreCase(attribute)) {
                			 result = childElement.getTextContent();
                			 logger.debug("Returning value from xml. Attribute=" + attribute + ", value=" +result);
                			 break;
                		 }
                	 }
                 }                    
             }
        }
        
        if(result.length() < 1) {
			 logger.debug("Unable to retrieve value from xml. Attribute=" + attribute + ", value=" +result);
            throw new RuntimeException("Unable to access xml attribute: " + attribute);
        } else {
	        return result;
        }

	} catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Unable to access xml file or test data within the xml file. Is there an entry for the test class and test name?");
	}
    
} 

public String getValue_ClassicEventsTestData(String attribute) {
	
	try {
		
    	String 					path = KeyValue.getGeneralProperty("ClassicEventsTestDataFilePath","Classic");
    	File 					inputFile = new File(path);
        DocumentBuilderFactory 	dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder 		dBuilder = dbFactory.newDocumentBuilder();
        Document 				doc = dBuilder.parse(inputFile);
        
        doc.getDocumentElement().normalize();
        
        NodeList 				nodeList = doc.getElementsByTagName("test");
        String					result = "";
        
        for (int i = 0; i < nodeList.getLength(); i++) {
        	 Node node = nodeList.item(i);
        	
             if(node.getNodeType() == Node.ELEMENT_NODE) {
            	 Element element = (Element) node;
            	 
            	 if(element.getAttribute("classname").equalsIgnoreCase(targetClass) && element.getAttribute("testname").equalsIgnoreCase(targetTest)) {
                	 NodeList childList = element.getElementsByTagName("parameter");
                	 
                	 for(int j = 0; j < childList.getLength(); j++) {
                		 Element childElement = (Element) childList.item(j);
                		 if(childElement.getAttribute("name").equalsIgnoreCase(attribute)) {
                			 result = childElement.getTextContent();
                			 logger.debug("Returning value from xml. Attribute=" + attribute + ", value=" +result);
                			 break;
                		 }
                	 }
                 }                    
             }
        }
        
        if(result.length() < 1) {
			 logger.debug("Unable to retrieve value from xml. Attribute=" + attribute + ", value=" +result);
            throw new RuntimeException("Unable to access xml attribute: " + attribute);
        } else {
	        return result;
        }

	} catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Unable to access xml file or test data within the xml file. Is there an entry for the test class and test name?");
	}
    
} 

public String getValue_ClassicShopsTestData(String attribute) {
	
	try {
		
    	String 					path = KeyValue.getGeneralProperty("ClassicShopsTestDataFilePath","Classic");
    	File 					inputFile = new File(path);
        DocumentBuilderFactory 	dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder 		dBuilder = dbFactory.newDocumentBuilder();
        Document 				doc = dBuilder.parse(inputFile);
        
        doc.getDocumentElement().normalize();
        
        NodeList 				nodeList = doc.getElementsByTagName("test");
        String					result = "";
        
        for (int i = 0; i < nodeList.getLength(); i++) {
        	 Node node = nodeList.item(i);
        	
             if(node.getNodeType() == Node.ELEMENT_NODE) {
            	 Element element = (Element) node;
            	 
            	 if(element.getAttribute("classname").equalsIgnoreCase(targetClass) && element.getAttribute("testname").equalsIgnoreCase(targetTest)) {
                	 NodeList childList = element.getElementsByTagName("parameter");
                	 
                	 for(int j = 0; j < childList.getLength(); j++) {
                		 Element childElement = (Element) childList.item(j);
                		 if(childElement.getAttribute("name").equalsIgnoreCase(attribute)) {
                			 result = childElement.getTextContent();
                			 logger.debug("Returning value from xml. Attribute=" + attribute + ", value=" +result);
                			 break;
                		 }
                	 }
                 }                    
             }
        }
        
        if(result.length() < 1) {
			 logger.debug("Unable to retrieve value from xml. Attribute=" + attribute + ", value=" +result);
            throw new RuntimeException("Unable to access xml attribute: " + attribute);
        } else {
	        return result;
        }

	} catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Unable to access xml file or test data within the xml file. Is there an entry for the test class and test name?");
	}
    
}

public String getValue_ClassicMembersTestData(String attribute) {
	
	try {
		
    	String 					path = KeyValue.getGeneralProperty("ClassicMembersTestDataFilePath","Classic");
    	File 					inputFile = new File(path);
        DocumentBuilderFactory 	dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder 		dBuilder = dbFactory.newDocumentBuilder();
        Document 				doc = dBuilder.parse(inputFile);
        
        doc.getDocumentElement().normalize();
        
        NodeList 				nodeList = doc.getElementsByTagName("test");
        String					result = "";
        
        for (int i = 0; i < nodeList.getLength(); i++) {
        	 Node node = nodeList.item(i);
        	
             if(node.getNodeType() == Node.ELEMENT_NODE) {
            	 Element element = (Element) node;
            	 
            	 if(element.getAttribute("classname").equalsIgnoreCase(targetClass) && element.getAttribute("testname").equalsIgnoreCase(targetTest)) {
                	 NodeList childList = element.getElementsByTagName("parameter");
                	 
                	 for(int j = 0; j < childList.getLength(); j++) {
                		 Element childElement = (Element) childList.item(j);
                		 if(childElement.getAttribute("name").equalsIgnoreCase(attribute)) {
                			 result = childElement.getTextContent();
                			 logger.debug("Returning value from xml. Attribute=" + attribute + ", value=" +result);
                			 break;
                		 }
                	 }
                 }                    
             }
        }
        
        if(result.length() < 1) {
			 logger.debug("Unable to retrieve value from xml. Attribute=" + attribute + ", value=" +result);
            throw new RuntimeException("Unable to access xml attribute: " + attribute);
        } else {
	        return result;
        }

	} catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Unable to access xml file or test data within the xml file. Is there an entry for the test class and test name?");
	}
    
}

public String getValue_FSPAusKickPlayerTestData(String attribute) {
	
	try {
		
    	String 					path = KeyValue.getGeneralProperty("FSPAusKickPlayerTestDataFilePath","FSP");
    	File 					inputFile = new File(path);
        DocumentBuilderFactory 	dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder 		dBuilder = dbFactory.newDocumentBuilder();
        Document 				doc = dBuilder.parse(inputFile);
        
        doc.getDocumentElement().normalize();
        
        NodeList 				nodeList = doc.getElementsByTagName("test");
        String					result = "";
        
        for (int i = 0; i < nodeList.getLength(); i++) {
        	 Node node = nodeList.item(i);
        	
             if(node.getNodeType() == Node.ELEMENT_NODE) {
            	 Element element = (Element) node;
            	 
            	 if(element.getAttribute("classname").equalsIgnoreCase(targetClass) && element.getAttribute("testname").equalsIgnoreCase(targetTest)) {
                	 NodeList childList = element.getElementsByTagName("parameter");
                	 
                	 for(int j = 0; j < childList.getLength(); j++) {
                		 Element childElement = (Element) childList.item(j);
                		 if(childElement.getAttribute("name").equalsIgnoreCase(attribute)) {
                			 result = childElement.getTextContent();
                			 logger.debug("Returning value from xml. Attribute=" + attribute + ", value=" +result);
                			 break;
                		 }
                	 }
                 }                    
             }
        }
        
        if(result.length() < 1) {
			 logger.debug("Unable to retrieve value from xml. Attribute=" + attribute + ", value=" +result);
            throw new RuntimeException("Unable to access xml attribute: " + attribute);
        } else {
	        return result;
        }

	} catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Unable to access xml file or test data within the xml file. Is there an entry for the test class and test name?");
	}
    
}

public String getValue_FSPRugbyTestData(String attribute) {
	
	try {
		
    	String 					path = KeyValue.getGeneralProperty("FSPRugbyTestDataFilePath","FSP");
    	File 					inputFile = new File(path);
        DocumentBuilderFactory 	dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder 		dBuilder = dbFactory.newDocumentBuilder();
        Document 				doc = dBuilder.parse(inputFile);
        
        doc.getDocumentElement().normalize();
        
        NodeList 				nodeList = doc.getElementsByTagName("test");
        String					result = "";
        
        for (int i = 0; i < nodeList.getLength(); i++) {
        	 Node node = nodeList.item(i);
        	
             if(node.getNodeType() == Node.ELEMENT_NODE) {
            	 Element element = (Element) node;
            	 
            	 if(element.getAttribute("classname").equalsIgnoreCase(targetClass) && element.getAttribute("testname").equalsIgnoreCase(targetTest)) {
                	 NodeList childList = element.getElementsByTagName("parameter");
                	 
                	 for(int j = 0; j < childList.getLength(); j++) {
                		 Element childElement = (Element) childList.item(j);
                		 if(childElement.getAttribute("name").equalsIgnoreCase(attribute)) {
                			 result = childElement.getTextContent();
                			 logger.debug("Returning value from xml. Attribute=" + attribute + ", value=" +result);
                			 break;
                		 }
                	 }
                 }                    
             }
        }
        
        if(result.length() < 1) {
			 logger.debug("Unable to retrieve value from xml. Attribute=" + attribute + ", value=" +result);
            throw new RuntimeException("Unable to access xml attribute: " + attribute);
        } else {
	        return result;
        }

	} catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Unable to access xml file or test data within the xml file. Is there an entry for the test class and test name?");
	}
    
}
}

