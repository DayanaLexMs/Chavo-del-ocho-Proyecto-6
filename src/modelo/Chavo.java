/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Chavo extends Personaje {
    
    private int hambre;
    private boolean llorando;
    private boolean jugar;

    public Chavo() {
    }

    public Chavo(int hambre, boolean llorando, boolean jugar, String nombre, int edad, String personalidad, String rol, double energia, String emocion) {
        super(nombre, edad, personalidad, rol, energia, emocion);
        this.hambre = hambre;
        this.llorando = llorando;
        this.jugar = jugar;
    }

    public int getHambre() {
        return hambre;
    }

    public void setHambre(int hambre) {
        this.hambre = hambre;
    }

    public boolean isLlorando() {
        return llorando;
    }

    public void setLlorando(boolean llorando) {
        this.llorando = llorando;
    }

    public boolean isJugar() {
        return jugar;
    }

    public void setJugar(boolean jugar) {
        this.jugar = jugar;
    }
    
    
    
}
