package org.esgi.use_case.project.domain;

import java.util.List;

public final class ProjectValidator {
    public boolean isValid(Project project){
        return isNotEmpty(project.getName()) &&
                isNotEmpty(project.getDescription()) &&
                isValidDailyRate(project.getDailyRate()) &&
                isValidDuration(project.getDuration()) &&
                isNotEmpty(project.getLocation()) &&
                isValidJobs(project.getJobs());
    }

    private boolean isValidJobs(List<String> jobs) {
        if(jobs.size() >= 1) return true;
        System.out.println("You must give one ore more job(s).");
        return false;
    }

    private static boolean isNotEmpty(String value){
        if(value != null && !value.equals("")) return true;
        System.out.println("You must give a name / description to your project.");
        return false;
    }

    private static boolean isValidDailyRate(Double dailyRate){
        if(dailyRate != null && dailyRate > 1 && dailyRate < 13) return true;
        System.out.println("Daily rate need to be between 1 and 13 hour / day.");
        return false;
    }

    private static boolean isValidDuration(Double duration){
        if(duration != null && duration >= 1) return true;
        System.out.println("Duration must be min 1 day");
        return false;
    }
}
