/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Chavo extends Personaje {
    private int hambre;
    private boolean estaLlorando;
    private boolean quiereJugar;
 
    public Chavo(String nombre, int edad, String personalidad, String rol, int energia, int hambre, String emocion, boolean estaLlorando, boolean quiereJugar) {
        super(nombre, edad, personalidad, rol, energia, emocion);
        this.hambre = hambre;
        this.estaLlorando = estaLlorando;
        this.quiereJugar = quiereJugar;
    }
 
    public int getHambre() { return hambre; }
    public void setHambre(int hambre) { this.hambre = hambre; }
    public boolean getEstaLlorando() { return estaLlorando; }
    public void setEstaLlorando(boolean estaLlorando) { this.estaLlorando = estaLlorando; }
    public boolean getQuiereJugar() { return quiereJugar; }
    public void setQuiereJugar(boolean quiereJugar) { this.quiereJugar = quiereJugar; }
 
    @Override
    public void hablar() {
        System.out.println("¡Fue sin querer queriendo!");
    }
 
    @Override
    public void realizarAccion() {
        pedirTortaJamon();
    }
 
    public void llorar() {
        this.estaLlorando = true;
        this.emocion = "Llorando";
        System.out.println(nombre + " está llorando: ¡Buaaaa!");
    }
 
    public void pedirTortaJamon() {
        System.out.println(nombre + " pide: ¡Una torta de jamón!");
    }
 
    public void esconderseBanil() {
        System.out.println(nombre + " se esconde en su barril.");
    }
 
    @Override
    public void recibirGolpe() {
        this.energia -= 10;
        this.emocion = "Asustado";
        llorar();
        System.out.println(nombre + " recibió un golpe. Energía restante: " + energia);
    }
}
