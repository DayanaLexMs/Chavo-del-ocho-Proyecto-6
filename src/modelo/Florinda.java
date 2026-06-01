/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Florinda extends Personaje{
    
    private boolean torta;

    public Florinda() {
    }
    
    public Florinda(boolean torta, String nombre, int edad, String personalidad, String rol, double energia, String emocion) {
        super(nombre, edad, personalidad, rol, energia, emocion);
        this.torta = torta;
    }

    public boolean isTorta() {
        return torta;
    }

    public void setTorta(boolean torta) {
        this.torta = torta;
    }
    
    
    
}
