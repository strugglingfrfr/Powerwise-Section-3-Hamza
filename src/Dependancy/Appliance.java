/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dependancy;

/**
 *
 * @author apple
 */

public class Appliance {

    // Fields
    private String name;
    private int wattage;
    private int hoursPerDay;

    // Empty constructor
    public Appliance() {
    }

    // Full constructor
    public Appliance(String name, int wattage, int hoursPerDay) {
        this.name = name;
        this.wattage = wattage;
        this.hoursPerDay = hoursPerDay;
    }

    //setters and getters
    public void setName(String name) {
        this.name = name;
    }
    
    public void setWattage(int wattage) {
        this.wattage = wattage;
    }
    
    public void setHoursPerDay(int hoursPerDay) {
        this.hoursPerDay = hoursPerDay;
    }

    public String getName() {
        return name;
    }
    
    public int getWattage() {
        return wattage;
    }

    public int getHoursPerDay() {
        return hoursPerDay;
    }
    

    

    // Returns appliance information as a single line of text
    public String printDetails() {
        return "Appliance: " + name + ", Wattage: " + wattage + ", Hours/Day: " + hoursPerDay;
    }
}
