package com.gmail.gwonii.jobrom.model;

public class JobModel {

    private static int jobId = 0;
    private String name;
    private String ability;
    private String salary;

    public JobModel(String name, String ability, String salary) {
        jobId++;
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

    @Override
    public String toString() {
        return "JobModel{" +
                "name='" + name + '\'' +
                ", ability='" + ability + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
