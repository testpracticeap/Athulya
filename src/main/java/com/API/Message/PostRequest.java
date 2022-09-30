package com.API.Message;

public class PostRequest {
	private String projectName;
	private String projectAuthor;
	private String projectDescription;
	
	public PostRequest() {
		
	}
	public PostRequest(String projectName, String projectAuthor, String projectDescription) {
		this.projectName = projectName;
		this.projectAuthor = projectAuthor;
		this.projectDescription = projectDescription;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectAuthor() {
		return projectAuthor;
	}

	public void setProjectAuthor(String projectAuthor) {
		this.projectAuthor = projectAuthor;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

}
