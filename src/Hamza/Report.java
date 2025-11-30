/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hamza;

/**
 *
 * @author apple  
 */
public class Report {

    private String applianceName;
    private double dailyUsage;
    private double weeklyUsage;
    private double monthlyUsage;
    private double yearlyUsage;
    private double monthlyCost;
    private double recommendedDailyUsage;
    private String usageAnalysis;
    private String prediction;
    private String tip;
    private String dateGenerated;
    private int recommendedHours;


    // Empty constructor
    public Report() {
    }

    // Main constructor for required fields
    public Report(String applianceName, double dailyUsage, double weeklyUsage, double monthlyUsage, String tip, String dateGenerated) {
        this.applianceName = applianceName;
        this.dailyUsage = dailyUsage;
        this.weeklyUsage = weeklyUsage;
        this.monthlyUsage = monthlyUsage;
        this.tip = tip;
        this.dateGenerated = dateGenerated;
    }

    // setters and getters for all fields
    public void setApplianceName(String applianceName) {
        this.applianceName = applianceName;
    }

    public void setDailyUsage(double dailyUsage) {
        this.dailyUsage = dailyUsage;
    }

    public void setWeeklyUsage(double weeklyUsage) {
        this.weeklyUsage = weeklyUsage;
    }

    public void setMonthlyUsage(double monthlyUsage) {
        this.monthlyUsage = monthlyUsage;
    }

    public void setYearlyUsage(double yearlyUsage) {
        this.yearlyUsage = yearlyUsage;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public void setRecommendedDailyUsage(double recommendedDailyUsage) {
        this.recommendedDailyUsage = recommendedDailyUsage;
    }

    public void setUsageAnalysis(String usageAnalysis) {
        this.usageAnalysis = usageAnalysis;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public void setDateGenerated(String dateGenerated) {
        this.dateGenerated = dateGenerated;
    }
    
    public void setRecommendedHours(int hours) {
    this.recommendedHours = hours;
    }

    public String getApplianceName() {
        return applianceName;
    }

    public double getDailyUsage() {
        return dailyUsage;
    }

    public double getWeeklyUsage() {
        return weeklyUsage;
    }

    public double getMonthlyUsage() {
        return monthlyUsage;
    }

    public double getYearlyUsage() {
        return yearlyUsage;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public double getRecommendedDailyUsage() {
        return recommendedDailyUsage;
    }

    public String getUsageAnalysis() {
        return usageAnalysis;
    }

    public String getPrediction() {
        return prediction;
    }

    public String getTip() {
        return tip;
    }

    public String getDateGenerated() {
        return dateGenerated;
    }
    
    public int getRecommendedHours() {
    return recommendedHours;
    }

    // Returns the full report as formatted text
    public String printReport() {

    // Calculation for Co2 emmissions
    double yearlyCost = yearlyUsage * 0.30;                     // €0.30 per kWh
    double carbonEmissions = monthlyUsage * 0.233;              // 0.233 kg CO₂ per kWh

    // Efficiency rating based on daily usage 
    String efficiencyRating;
    if (dailyUsage < 1.0) efficiencyRating = "A";
    else if (dailyUsage < 2.5) efficiencyRating = "B";
    else if (dailyUsage < 4.0) efficiencyRating = "C";
    else if (dailyUsage < 6.0) efficiencyRating = "D";
    else efficiencyRating = "E";

    // Efficiency score (0–10)
    double score;
    if (recommendedDailyUsage == 0) {
        score = 5;
    } else {
        double diff = Math.abs(dailyUsage - recommendedDailyUsage);
        score = Math.max(0, 10 - (diff * 2)); // larger difference = lower score
    }
    int efficiencyScore = (int)Math.round(score);

    // Appliance insights (simple hardcoded categories)
    String insight = "";
    String lower = applianceName.toLowerCase();

    if (lower.contains("fridge")) {
        insight = "Fridges typically account for ~15% of household electricity use.\n"
                + "Keeping temperature between 3–5°C improves efficiency.";
    } 
    else if (lower.contains("heater")) {
        insight = "Heaters are high-consumption appliances. Reduce usage and improve insulation\n"
                + "to lower energy waste.";
    } 
    else if (lower.contains("laptop")) {
        insight = "Laptops consume less energy than desktops. Enable battery saver and reduce\n"
                + "screen brightness for optimal efficiency.";
    } 
    else if (lower.contains("tv")) {
        insight = "Modern LED TVs are efficient, but long daily usage increases cost.\n"
                + "Use auto-power-off and reduce brightness to save energy.";
    } 
    else {
        insight = "General appliance: monitor your usage patterns to identify savings.";
    }

    //Final report formmating and output
    return
        "PowerWise Energy Report\n" +

        "Appliance: " + applianceName + "\n\n" +

        "USAGE SUMMARY\n" +
        "• Daily Usage: " + String.format("%.2f", dailyUsage) + " kWh\n" +
        "• Weekly Usage: " + String.format("%.2f", weeklyUsage) + " kWh\n" +
        "• Monthly Usage: " + String.format("%.2f", monthlyUsage) + " kWh\n" +
        "• Yearly Usage: " + String.format("%.2f", yearlyUsage) + " kWh\n\n" +

        "COST ESTIMATES\n" +
        "• Monthly Cost: €" + String.format("%.2f", monthlyCost) + "\n" +
        "• Yearly Cost: €" + String.format("%.2f", yearlyCost) + "\n\n" +

        "CARBON FOOTPRINT\n" +
        "• Estimated Emissions: " + String.format("%.2f", carbonEmissions) + " kg CO₂ / month\n\n" +

        "EFFICIENCY\n" +
        "• Recommended Hours/Day: " + recommendedHours + " hours\n" +
        "• Recommended Daily Usage: " + String.format("%.2f", recommendedDailyUsage) + " kWh\n" +
        "• Efficiency Rating: " + efficiencyRating + "\n" +
        "• Efficiency Score: " + efficiencyScore + "/10\n" +
        "• Usage Analysis: " + usageAnalysis + "\n\n" +

        "FORECAST\n" +
        "• " + prediction + "\n\n" +

        "APPLIANCE INSIGHT\n" +
        insight + "\n\n" +

        "TIPS\n" +
        tip + "\n\n" +

        "Date Generated: " + dateGenerated + "\n";
    }

}