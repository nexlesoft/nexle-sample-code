package com.core.utilities;

import org.apache.log4j.Logger;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runners.model.Statement;

public class RetryRule implements TestRule {

	private int retryCount;
	 
    public RetryRule (int retryCount) {
        this.retryCount = retryCount;
    }
    
    public Statement apply(Statement base, Description description) {
        return statement(base, description);
    }
    
    private Statement statement(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                Throwable caughtThrowable = null;
 
                // implement retry logic here
                for (int i = 0; i < retryCount; i++) {
                    try {
                        base.evaluate();
                        return;
                    } catch (Throwable t) {
                        caughtThrowable = t;
                        System.err.println(description.getDisplayName() + ": Run " + (i + 1) + " failed.");
                        if (i+1 != retryCount)
                        {
                        	Failure failure = new Failure(description, t);
                        	String failuremsg = failure.getTrace();
                        	if(util_TestWatcher.runID!=null & !util_TestWatcher.testCaseID.equalsIgnoreCase("") )
                        	{
                        		util_TestRail.updateTestResult(util_TestWatcher.runID, util_TestWatcher.testCaseID, "Failed","Run " + (i + 1) + " failed." +  '\n'+ failuremsg);
                        	}
                        }
                    }
                }
                System.err.println(description.getDisplayName() + ": Giving up after " + retryCount + " failures.");
                throw caughtThrowable;
            }
        };
    }

}
