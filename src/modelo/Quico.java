/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Quico extends Personaje{
    
    private boolean juguete;

    public Quico() {
    }
    
    public Quico(boolean juguete, String nombre, int edad, String personalidad, String rol, double energia, String emocion) {
        super(nombre, edad, personalidad, rol, energia, emocion);
        this.juguete = juguete;
    }

    public boolean isJuguete() {
        return juguete;
    }

    public void setJuguete(boolean juguete) {
        this.juguete = juguete;
    }
    
    
    
}
