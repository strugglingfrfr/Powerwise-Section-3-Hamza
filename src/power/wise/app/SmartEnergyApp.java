/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package power.wise.app;

/**
 *
 * @author apple
 */
public class SmartEnergyApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //starting the app
        java.awt.EventQueue.invokeLater(() -> {
            new PowerWiseGUI().setVisible(true);
        });
    }
    
}
