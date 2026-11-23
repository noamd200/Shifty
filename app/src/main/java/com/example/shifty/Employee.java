package com.example.shifty;

import java.util.ArrayList;
import java.util.List;

public class Employee extends User {

    private double hourlyWage;
    private List<String> shiftIds; // Stores the IDs of assigned shifts

    // Required empty constructor for Firebase
    public Employee() {
        super();
        this.shiftIds = new ArrayList<>();
    }

    public Employee(String userId, String userName, String email, double hourlyWage, List<String> shiftIds) {
        super(userId, userName, email, UserRole.EMPLOYEE);
        this.hourlyWage = hourlyWage;
        this.shiftIds = (shiftIds != null) ? shiftIds : new ArrayList<>();
    }

    // Helper method to calculate total salary from a list of completed shifts
    public double calculateTotalSalary(List<Shift> shifts) {
        double totalHours = 0.0;
        if (shifts != null) {
            for (Shift shift : shifts) {
                if (shift.getStatus() == Shift.ShiftStatus.COMPLETED) {
                    totalHours += shift.getHours();
                }
            }
        }
        return totalHours * this.hourlyWage;
    }

    // --- Getters and Setters ---

    public double getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(double hourlyWage) {
        this.hourlyWage = hourlyWage;
    }

    public List<String> getShiftIds() {
        return shiftIds;
    }

    public void setShiftIds(List<String> shiftIds) {
        this.shiftIds = shiftIds;
    }
}