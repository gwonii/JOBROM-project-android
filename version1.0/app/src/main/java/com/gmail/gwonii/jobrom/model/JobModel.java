package com.gmail.gwonii.jobrom.model;

public class JobModel {

    private int jobId = 0;
    private String name;
    private String ability;
    private String salary;

    public JobModel() {
        this.name = "";
        this.ability = "";
        this.salary = "";
    }

    public JobModel(String name, String ability, String salary) {
        this.name = name;
        this.ability = ability;
        this.salary = salary;
    }


    public int getJobId() {
        return jobId;
    }

    public String getName() {
        return name;
    }

    public String getAbility() {
        return ability;
    }

    public String getSalary() {
        return salary;
    }


    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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
