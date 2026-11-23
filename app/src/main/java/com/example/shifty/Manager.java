package com.example.shifty;

public class Manager extends User {

    private String businessName;
    private double businessLatitude;
    private double businessLongitude;
    private double allowedRadiusMeters; // e.g., 100.0 meters radius for GPS clock-in

    // Required empty constructor for Firebase
    public Manager() {
        super();
    }

    public Manager(String userId, String userName, String email, String businessName,
                   double businessLatitude, double businessLongitude, double allowedRadiusMeters) {
        super(userId, userName, email, UserRole.MANAGER);
        this.businessName = businessName;
        this.businessLatitude = businessLatitude;
        this.businessLongitude = businessLongitude;
        this.allowedRadiusMeters = allowedRadiusMeters;
    }

    // --- Getters and Setters ---

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public double getBusinessLatitude() {
        return businessLatitude;
    }

    public void setBusinessLatitude(double businessLatitude) {
        this.businessLatitude = businessLatitude;
    }

    public double getBusinessLongitude() {
        return businessLongitude;
    }

    public void setBusinessLongitude(double businessLongitude) {
        this.businessLongitude = businessLongitude;
    }

    public double getAllowedRadiusMeters() {
        return allowedRadiusMeters;
    }

    public void setAllowedRadiusMeters(double allowedRadiusMeters) {
        this.allowedRadiusMeters = allowedRadiusMeters;
    }
}