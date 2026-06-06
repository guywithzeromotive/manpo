package com.zero.manpo.models;

public class Report {

    //TODO: add missing status, report type, image
    private String projectName;
    private ReportType reportType;
    private String projectLink;
    private String projectDescription;
    private String projectDeepDive;

    public Report(String projectName, ReportType reportType, String projectLink, String projectDescription, String projectDeepDive){
        this.projectName = projectName;
        this.reportType = reportType;
        this.projectLink = projectLink;
        this.projectDescription =  projectDescription;
        this.projectDeepDive = projectDeepDive;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
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

    public ReportType getReportType() {
        return reportType;
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
