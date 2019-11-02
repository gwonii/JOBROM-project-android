package com.gmail.gwonii.jobrom.model;

public class JobModel {

    private static int jobId = 0;
    private String jobName;
    private String jobAbility;
    private String jobSalery;

    public JobModel(String jobName, String jobAbility, String jobSalery) {
        jobId++;
        this.jobName = jobName;
        this.jobAbility = jobAbility;
        this.jobSalery = jobSalery;
    }


    public int getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public String getJobAbility() {
        return jobAbility;
    }

    public String getJobSalery() {
        return jobSalery;
    }
}
