package com.gmail.gwonii.jobrom.model;

public class JobModel {

    private int jobId = 0;
    private String name;
    private String division;
    private String ability;
    private String preparation;
    private String summary;
    private String salary;
    private String equality;
    private String potential;
    private String outlook;
    private String environment;
    private String requiredAbility;
    private String knowledge;


    public JobModel() {
    }

    public JobModel(String name, String division, String ability, String preparation, String summary, String salary, String equality, String potential, String outlook, String environment, String requiredAbility, String knowledge) {
        this.name = name;
        this.division = division;
        this.ability = ability;
        this.preparation = preparation;
        this.summary = summary;
        this.salary = salary;
        this.equality = equality;
        this.potential = potential;
        this.outlook = outlook;
        this.environment = environment;
        this.requiredAbility = requiredAbility;
        this.knowledge = knowledge;
    }


    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
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

    public String getEquality() {
        return equality;
    }

    public void setEquality(String equality) {
        this.equality = equality;
    }

    public String getPotential() {
        return potential;
    }

    public void setPotential(String potential) {
        this.potential = potential;
    }

    public String getOutlook() {
        return outlook;
    }

    public void setOutlook(String outlook) {
        this.outlook = outlook;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getRequiredAbility() {
        return requiredAbility;
    }

    public void setRequiredAbility(String requiredAbility) {
        this.requiredAbility = requiredAbility;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    @Override
    public String toString() {
        return "JobModel{" +
                "name='" + name + '\'' +
                ", division='" + division + '\'' +
                ", ability='" + ability + '\'' +
                ", preparation='" + preparation + '\'' +
                ", summary='" + summary + '\'' +
                ", salary='" + salary + '\'' +
                ", equality='" + equality + '\'' +
                ", potential='" + potential + '\'' +
                ", outlook='" + outlook + '\'' +
                ", environment='" + environment + '\'' +
                ", requiredAbility='" + requiredAbility + '\'' +
                ", knowledge='" + knowledge + '\'' +
                '}';
    }
}
