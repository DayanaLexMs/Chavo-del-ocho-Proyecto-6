/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public abstract class Personaje {
    protected String nombre;
    protected int edad;
    protected String personalidad;
    protected String rol;
    protected int energia;
    protected String emocion;
 
    public Personaje(String nombre, int edad, String personalidad, String rol, int energia, String emocion) {
        this.nombre = nombre;
        this.edad = edad;
        this.personalidad = personalidad;
        this.rol = rol;
        this.energia = energia;
        this.emocion = emocion;
    }
 
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getPersonalidad() { return personalidad; }
    public void setPersonalidad(String personalidad) { this.personalidad = personalidad; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
    public int getEnergia() { return energia; }
    public void setEnergia(int energia) { this.energia = energia; }
    public String getEmocion() { return emocion; }
    public void setEmocion(String emocion) { this.emocion = emocion; }
 
    public abstract void hablar();
    public abstract void realizarAccion();
    public abstract void recibirGolpe();
 
    @Override
    public String toString() {
        return nombre + " (Edad: " + edad + ", Rol: " + rol + ")";
    }
}