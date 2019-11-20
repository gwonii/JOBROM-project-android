package com.gmail.gwonii.jobrom.model;

public class JobModel {

    private int jobId = 0;
    private String name;
    private String ability;
    private String salary;

    public JobModel(String name, String ability, String salary) {
        this.name = name;
        this.ability = ability;
        this.salary = salary;
    }

    public int getJobId() {
        return jobId;
    }

    public String getJobName() {
        return name;
    }

    public String getJobAbility() {
        return ability;
    }

    public String getSalary() {
        return salary;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Override
    public String toString() {
        return "JobModel{" +
                "jobId=" + jobId +
                ", name='" + name + '\'' +
                ", ability='" + ability + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
