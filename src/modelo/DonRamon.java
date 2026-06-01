/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class DonRamon extends Personaje {
    private int deudaRenta;
 
    public DonRamon(String nombre, int edad, String personalidad, String rol, int energia, String emocion, int deudaRenta) {
        super(nombre, edad, personalidad, rol, energia, emocion);
        this.deudaRenta = deudaRenta;
    }
 
    public int getDeudaRenta() { return deudaRenta; }
    public void setDeudaRenta(int deudaRenta) { this.deudaRenta = deudaRenta; }
 
    @Override
    public void hablar() {
        System.out.println("¡Niño, ¿qué le pasa a usted?!");
    }
 
    @Override
    public void realizarAccion() {
        esconderseCasa();
    }
 
    public void esconderseCasa() {
        this.emocion = "Nervioso";
        System.out.println(nombre + " se esconde para no pagar la renta.");
    }
 
    @Override
    public void recibirGolpe() {
        this.energia -= 10;
        this.emocion = "Adolorido";
        System.out.println(nombre + " recibió un golpe. Energía: " + energia);
    }
}
