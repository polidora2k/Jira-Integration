package listeners;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

import jira.JiraClient;
import metaData.MetaData;

public class TestListener implements ITestListener {
	public void onTestFailure(ITestResult result) {

		// first lets get the annotation value from the failed test case. 
        MetaData meta = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(MetaData.class);
        
        // get the annotation parameter value as a boolean
        boolean isProductionReady = meta.ready();
        // Check if the annotation attribute value is productionReady=true
        if (isProductionReady) {
            System.out.println("IS PRODUCTION READY : "+isProductionReady);
            JiraClient jira = new JiraClient("polidora2k@gmail.com", "CJXHQLJv4Wi1aYyTyubCA31F", "https://polidoraian.atlassian.net");
            
            // Add the failed method name as the issue summary
            String issueSummary = result.getMethod().getConstructorOrMethod().getMethod().getName() + " was failed due to an exception";
            
            // get the error message from the exception to description
            String issueDescription = "Exception details : "+  result.getThrowable().getMessage() + "\n";
            // Append the full stack trace to the description.
            issueDescription.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));
            
            jira.createIssue("SIT", "Bug", issueSummary, issueDescription);
        }
	}
}
