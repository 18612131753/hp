package com.yghsh.wx.hp.model;

/**
 * Created by ray on 2016-9-23.
 */
public class HpDataAnalysisResult {
    private String jobId ;
    private String text ;
    private String orgtext ;
    private String label ;
    private String prediction ;
    private String group ;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOrgtext() {
        return orgtext;
    }

    public void setOrgtext(String orgtext) {
        this.orgtext = orgtext;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
