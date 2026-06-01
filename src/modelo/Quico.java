/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class Quico extends Personaje {
    private boolean tieneJugueteN;
 
    public Quico(String nombre, int edad, String personalidad, String rol, int energia, String emocion, boolean tieneJugueteN) {
        super(nombre, edad, personalidad, rol, energia, emocion);
        this.tieneJugueteN = tieneJugueteN;
    }
 
    public boolean getTieneJugueteN() { return tieneJugueteN; }
    public void setTieneJugueteN(boolean tieneJugueteN) { this.tieneJugueteN = tieneJugueteN; }
 
    @Override
    public void hablar() {
        System.out.println("¡Cállate, cállate, que me desesperas!");
    }
 
    @Override
    public void realizarAccion() {
        acusarMama();
    }
 
    public void acusarMama() {
        this.emocion = "Enojado";
        System.out.println(nombre + " corre a acusar con su mamá: ¡Mamáaaaa!");
    }
 
    public void golpearPersonaje(Personaje personajeGolp) {
        this.emocion = "Satisfecho";
        personajeGolp.recibirGolpe();
        System.out.println(nombre + " golpeó a " + personajeGolp.getNombre());
    }
 
    @Override
    public void recibirGolpe() {
        this.energia -= 10;
        this.emocion = "Llorando";
        System.out.println(nombre + " recibió un golpe. ¡Mamaaaá! Energía: " + energia);
    }
}
