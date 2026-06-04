package com.zero.manpo.models;

public class Report {

    //TODO: add missing status, report type, image
    private String projectName;
    private String projectLink;
    private String projectDescription;
    private String projectDeepDive;

    Report(String projectName, String projectLink, String projectDescription, String projectDeepDive){
        this.projectName = projectName;
        this.projectLink = projectLink;
        this.projectDescription =  projectDescription;
        this.projectDeepDive = projectDeepDive;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public void setProjectDeepDive(String projectDeepDive) {
        this.projectDeepDive = projectDeepDive;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public String getProjectDeepDive() {
        return projectDeepDive;
    }
}
