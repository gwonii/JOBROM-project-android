package com.gmail.gwonii.jobrom.model;

public class JobListModel {


    private String name;
    private String summary;
    private String salary;

    public JobListModel(String name, String summary, String salary) {
        this.name = name;
        this.summary = summary;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "JobListModel{" +
                "name='" + name + '\'' +
                ", summary='" + summary + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
