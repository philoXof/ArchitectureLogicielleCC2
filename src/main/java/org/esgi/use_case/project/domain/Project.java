package org.esgi.use_case.project.domain;

import java.util.List;
import java.util.Objects;

public final class Project {
    private final ProjectId id;
    private String name;
    private String description;
    private List<String> jobs;
    private List<String> skills;
    private String location;
    private double dailyRate;
    private double duration;
    private boolean isValid;

    public Project(ProjectId id, String name, String description, List<String> jobs, List<String> skills, String location, double dailyRate, double duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.jobs = jobs;
        this.skills = skills;
        this.location = location;
        this.dailyRate = dailyRate;
        this.duration = duration;
    }

    public static Project of(ProjectId id, String name, String description, List<String> jobs, List<String> skills, String location, double dailyRate, double duration){
        return new Project(id, name, description, jobs, skills, location, dailyRate, duration);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Double.compare(project.dailyRate, dailyRate) == 0 && Double.compare(project.duration, duration) == 0 && Objects.equals(id, project.id) && Objects.equals(name, project.name) && Objects.equals(description, project.description) && Objects.equals(jobs, project.jobs) && Objects.equals(skills, project.skills) && Objects.equals(location, project.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, jobs, skills, location, dailyRate, duration);
    }

    public ProjectId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getJobs() {
        return jobs;
    }

    public void setJobs(List<String> jobs) {
        this.jobs = jobs;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid() {
        isValid = true;
    }

    public void setInvalid(){
        isValid = false;
    }
}
