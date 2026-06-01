/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class SeñorBarriga extends Personaje {
    
    private double cantGolpes;
    private ArrayList <Casa> casas;

    public SeñorBarriga(double cantGolpes, ArrayList<Casa> casas) {
        this.cantGolpes = cantGolpes;
        this.casas = casas;
    }

    public SeñorBarriga(double cantGolpes, ArrayList<Casa> casas, String nombre, int edad, String personalidad, String rol, double energia, String emocion) {
        super(nombre, edad, personalidad, rol, energia, emocion);
        this.cantGolpes = cantGolpes;
        this.casas = casas;
    }

    public double getCantGolpes() {
        return cantGolpes;
    }

    public void setCantGolpes(double cantGolpes) {
        this.cantGolpes = cantGolpes;
    }

    public ArrayList<Casa> getCasas() {
        return casas;
    }

    public void setCasas(ArrayList<Casa> casas) {
        this.casas = casas;
    }
    
    
    
}
