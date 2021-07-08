package jira;

public class JiraTest2 {

	public static void main(String[] args) {
		JiraClient jira = new JiraClient("polidora2k@gmail.com", "CJXHQLJv4Wi1aYyTyubCA31F", "https://polidoraian.atlassian.net");
		/*jira.createIssue("SIT", "Bug", "Jira Testing 2");
		jira.createIssue("SIT", 10002, "Testing Task");
		jira.createIssue("SIT", "Improvement", "Testing Improvement", "Added a Description");
		jira.createIssue("SIT", 10004, "Testing New Feature", "Added a Description");
		jira.createIssue("SIT", 10002, "Testing Story", "Added a Description", 3);
		jira.createIssue("SIT", 10002, "Testing Sub Task", 2);
		jira.createIssue("SIT", "Bug", "Just Priority Bug", 4);*/
		
		Issue issue = jira.getIssue("SIT-46");
		issue.updateSummary("Updating Summary with UPDATE Keyword");
		issue.updateDescription("Updating Description Again with Update");
		issue.updatePriority(1);
		issue.updateEnvironment("Environment Check");
		issue.addAttachment("/Users/ipolidora/sad-employee.jpg");
		issue.addComment("This is a new comment");
		
	}

}