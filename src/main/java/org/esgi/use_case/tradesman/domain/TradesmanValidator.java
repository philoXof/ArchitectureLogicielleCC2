package org.esgi.use_case.tradesman.domain;

public final class TradesmanValidator {
    public boolean isValid(Tradesman tradesman){
        if(isValidName(tradesman.getFirstName()) &&
        isValidName(tradesman.getLastName())&&
        isValidSkills(tradesman.getSkills()) &&
        isValidDailyRate(tradesman.getDailyRate()) &&
        isValidQualificationCertificate(tradesman.getQualificationCertificate()) &&
        isValidLocation(tradesman.getLocation())) return true;
        System.out.println("Invalid tradesman");
        return false;
    }

    private static boolean isValidName(String value) {
        if (value != null && !value.equals("")) return true;
        System.out.println("You must set a firstName / lastName.");
        return false;
    }

    private static boolean isValidSkills(String value){
        if(value != null && !value.equals("")) return true;
        System.out.println("you must set some skills");
        return false;
    }

    private static boolean isValidDailyRate(double value){
        if(value > 1 && value < 13) return true;
        System.out.println("Daily rate need to be between 1 and 13 hour / day.");
        return false;
    }

    private static boolean isValidQualificationCertificate(String value){
        if(value != null && !value.equals("")) return true;
        System.out.println("You must set a certificate");
        return false;
    }

    private static boolean isValidLocation(String value){
        if(value != null && !value.equals("")) return true;
        System.out.println("You must set a location");
        return false;
    }

}
