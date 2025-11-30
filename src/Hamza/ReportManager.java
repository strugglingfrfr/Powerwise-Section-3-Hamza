/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hamza;

import Dependancy.Appliance;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;


/**
 *
 * @author apple
 */
public class ReportManager {

    
    // Generates a full report using an Appliance object from teh energy.txt file
    public Report generateReport(Appliance appliance) {
        
        String applianceName = appliance.getName();
        int wattage = appliance.getWattage();
        int hours = appliance.getHoursPerDay();
        
        // Converting to kWh
        double dailyUsage = (wattage * hours) / 1000.0;
        double weeklyUsage = dailyUsage * 7;
        double monthlyUsage = dailyUsage * 30;
        double yearlyUsage = dailyUsage * 365;
        
        // Cost estimate assuming €0.30 per kWh
        double costPerMonth = monthlyUsage * 0.30;

        // Recommended hours per day
        int recommendedHours = getRecommendedHours(applianceName);
        double recommendedDailyUsage = (wattage * recommendedHours) / 1000.0;

        // Usage analysis compared to recommended
        String usageAnalysis = "";
        if (hours > recommendedHours) {
            usageAnalysis = "Your usage is higher than recommended.";
        } else if (hours == recommendedHours) {
            usageAnalysis = "Your usage is within the recommended range.";
        } else {
            usageAnalysis = "Your usage is lower than recommended.";
        }

        // Prediction message
        String prediction = "If you continue like this, you will use " 
                + String.format("%.2f", yearlyUsage) 
                + " kWh this year.";

        // Hardcoded simple tip (will take tip from brian's section in full app flow)
        String tip = "Try reducing usage during peak hours to save energy.";

        // Today's date
        String dateGenerated = LocalDate.now().toString();

        // Create and return Report object
        Report report = new Report(
                applianceName,
                dailyUsage,
                weeklyUsage,
                monthlyUsage,
                tip,
                dateGenerated
        );

        // Adding extra fields to report using setters
        report.setYearlyUsage(yearlyUsage);
        report.setMonthlyCost(costPerMonth);
        report.setRecommendedDailyUsage(recommendedDailyUsage);
        report.setRecommendedHours(recommendedHours);
        report.setUsageAnalysis(usageAnalysis);
        report.setPrediction(prediction);

        return report;
    }

    // Returns recommended hours for an appliance
    private int getRecommendedHours(String applianceName) {
        applianceName = applianceName.toLowerCase();

        if (applianceName.contains("laptop")) return 6;
        if (applianceName.contains("tv")) return 8;
        if (applianceName.contains("heater")) return 3;
        if (applianceName.contains("fridge")) return 24;  
        if (applianceName.contains("washing machine")) return 2;

        return 3; // Default recommendation
    }

    // Saves a report to a file
    public void saveReport(Report report) {
        File f;
        FileWriter fw;
        BufferedWriter bw;

        try {
            f = new File("data/reports.txt");
            fw = new FileWriter(f, true);
            bw = new BufferedWriter(fw);

            bw.write("----- Report (" + report.getDateGenerated() + ") -----\n");
            bw.write(report.printReport() + "\n");
            bw.write("------------------------------------------\n\n");

            bw.close();
        } catch (Exception e) {
            System.out.println("Error saving report: " + e);
        }
    }

}