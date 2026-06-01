/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class DonRamon extends Personaje {
    
    private double deudaRenta;
    
    public DonRamon(double deudaRenta, String nombre, int edad, String personalidad, String rol, double energia, String emocion) {
        super(nombre, edad, personalidad, rol, energia, emocion);
        this.deudaRenta = deudaRenta;
    }

    public double getDeudaRenta() {
        return deudaRenta;
    }

    public void setDeudaRenta(double deudaRenta) {
        this.deudaRenta = deudaRenta;
    }
    
}
