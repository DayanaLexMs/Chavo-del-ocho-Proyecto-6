/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
 
public class SenorBarriga extends Personaje {
    private int cantGolpesBarriga;
    private ArrayList<Casa> listaCasasP;
 
    public SenorBarriga(String nombre, int edad, String personalidad, String rol, int energia, String emocion, int cantGolpesBarriga) {
        super(nombre, edad, personalidad, rol, energia, emocion);
        this.cantGolpesBarriga = cantGolpesBarriga;
        this.listaCasasP = new ArrayList<>();
    }
 
    public int getCantGolpesBarriga() { return cantGolpesBarriga; }
    public void setCantGolpesBarriga(int cantGolpesBarriga) { this.cantGolpesBarriga = cantGolpesBarriga; }
    public ArrayList<Casa> getListaCasasP() { return listaCasasP; }
    public void setListaCasasP(ArrayList<Casa> listaCasasP) { this.listaCasasP = listaCasasP; }
 
    @Override
    public void hablar() {
        System.out.println("¡Don Ramón! ¡La renta, Don Ramón!");
    }
 
    @Override
    public void realizarAccion() {
        cobrarRenta();
    }
 
    public void cobrarRenta() {
        this.emocion = "Insistente";
        System.out.println(nombre + " viene a cobrar la renta a todos los inquilinos.");
    }
 
    @Override
    public void recibirGolpe() {
        this.energia -= 8;
        this.cantGolpesBarriga++;
        this.emocion = "Sorprendido";
        System.out.println(nombre + " recibió un golpe en la barriga. Total golpes: " + cantGolpesBarriga);
    }
}
