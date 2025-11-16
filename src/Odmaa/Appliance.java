/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Odmaa;

/**
 *
 * @author apple
 */
public class Appliance {
    private String applianceName;
    private double energyUsage;
    private double wattage;
    private double hours;

    public Appliance() {
    }

    public Appliance(String applianceName, double energyUsage, double wattage, double hours) {
        this.applianceName = applianceName;
        this.energyUsage = energyUsage;
        this.wattage = wattage;
        this.hours = hours;
    }

    public String getApplianceName() {
        return applianceName;
    }

    public void setApplianceName(String applianceName) {
        this.applianceName = applianceName;
    }

    public double getEnergyUsage() {
        return energyUsage;
    }

    public void setEnergyUsage(double energyUsage) {
        this.energyUsage = energyUsage;
    }

    public double getWattage() {
        return wattage;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
    
    public double claculateEnergyUsage(){
        return energyUsage = wattage * hours ;
    }
    
    @Override
    public String toString(){
        return applianceName + " : energy usage is " + energyUsage;
    }
}
