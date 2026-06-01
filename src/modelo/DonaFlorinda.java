/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class DonaFlorinda extends Personaje {
    private boolean tieneTorta;
 
    public DonaFlorinda(String nombre, int edad, String personalidad, String rol, int energia, String emocion, boolean tieneTorta) {
        super(nombre, edad, personalidad, rol, energia, emocion);
        this.tieneTorta = tieneTorta;
    }
 
    public boolean getTieneTorta() { return tieneTorta; }
    public void setTieneTorta(boolean tieneTorta) { this.tieneTorta = tieneTorta; }
 
    @Override
    public void hablar() {
        System.out.println("¡Señor Barriga! ¡Le voy a contar a mi Quico!");
    }
 
    @Override
    public void realizarAccion() {
        darTortaJamon();
    }
 
    public void pegar() {
        this.emocion = "Enojada";
        System.out.println(nombre + " da un golpe con su bolso.");
    }
 
    public void darTortaJamon() {
        if (tieneTorta) {
            tieneTorta = false;
            System.out.println(nombre + " da una torta de jamón.");
        } else {
            System.out.println(nombre + " no tiene torta de jamón en este momento.");
        }
    }
 
    public void besarProfesor() {
        this.emocion = "Enamorada";
        System.out.println(nombre + " saluda al Profesor Jirafales con cariño.");
    }
 
    @Override
    public void recibirGolpe() {
        this.energia -= 5;
        this.emocion = "Indignada";
        System.out.println(nombre + " recibió un golpe. ¡Qué atrevimiento! Energía: " + energia);
    }
}
