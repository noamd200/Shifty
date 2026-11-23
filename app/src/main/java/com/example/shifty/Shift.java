package com.example.shifty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Shift {

    // Enum for the shift status
    public enum ShiftStatus {
        UPCOMING,
        ONGOING,
        COMPLETED
    }

    private String shiftId; // Useful for Firebase document/node IDs
    private Date startTime;
    private Date endTime;
    private ShiftStatus status;
    private List<String> employeeList; // List of employee UIDs (better than int[] for Firebase)
    private double hours;

    // 1. Empty constructor REQUIRED by Firebase for deserialization
    public Shift() {
        this.employeeList = new ArrayList<>();
    }

    // 2. Full constructor
    public Shift(String shiftId, Date startTime, Date endTime, ShiftStatus status, List<String> employeeList) {
        this.shiftId = shiftId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.employeeList = (employeeList != null) ? employeeList : new ArrayList<>();
        this.hours = calculateHours();
    }

    // Helper method to automatically calculate total shift duration in hours
    public double calculateHours() {
        if (startTime != null && endTime != null) {
            long diffInMillis = endTime.getTime() - startTime.getTime();
            if (diffInMillis > 0) {
                // Convert milliseconds to hours (e.g., 90 mins -> 1.5 hours)
                return (double) TimeUnit.MILLISECONDS.toMinutes(diffInMillis) / 60.0;
            }
        }
        return 0.0;
    }

    // --- Getters and Setters (Required for Firebase) ---

    public String getShiftId() {
        return shiftId;
    }

    public void setShiftId(String shiftId) {
        this.shiftId = shiftId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
        this.hours = calculateHours(); // Recalculate if start time changes
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
        this.hours = calculateHours(); // Recalculate if end time changes
    }

    public ShiftStatus getStatus() {
        return status;
    }

    public void setStatus(ShiftStatus status) {
        this.status = status;
    }

    public List<String> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<String> employeeList) {
        this.employeeList = employeeList;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
}