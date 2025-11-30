/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dependancy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author apple
 */
public class ApplianceManager {
    
    // Reads appliances from energy.txt and returns them in an ArrayList
    public ArrayList<Appliance> loadAppliances() {
        
        ArrayList<Appliance> list = new ArrayList<>();
        
        File f;
        FileReader fr;
        BufferedReader br;
        String line;

        try {
            // File containing appliance data
            f = new File("data/energy.txt");
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            // Read file line by line
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                // Ensures the line contains the expected 3 values
                if (parts.length == 3) {
                    String name = parts[0];
                    int wattage = Integer.parseInt(parts[1]);
                    int hours = Integer.parseInt(parts[2]);

                    Appliance a = new Appliance(name, wattage, hours);
                    list.add(a);
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println("Error loading appliance data: " + e);
        }
        
        return list;
    }
}
