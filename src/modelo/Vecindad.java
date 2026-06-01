/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;
 
public class Vecindad {
    private String nombre;
    private ArrayList<Casa> listaCasas;
    private Patio patio;
    private ArrayList<Personaje> listaPersonajes;
 
    public Vecindad(String nombre, ArrayList<Casa> listaCasas, Patio patio, ArrayList<Personaje> listaPersonajes) {
        this.nombre = nombre;
        this.listaCasas = listaCasas != null ? listaCasas : new ArrayList<>();
        this.patio = patio;
        this.listaPersonajes = listaPersonajes != null ? listaPersonajes : new ArrayList<>();
    }
 
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public ArrayList<Casa> getListaCasas() { return listaCasas; }
    public void setListaCasas(ArrayList<Casa> listaCasas) { this.listaCasas = listaCasas; }
    public Patio getPatio() { return patio; }
    public void setPatio(Patio patio) { this.patio = patio; }
    public ArrayList<Personaje> getListaPersonajes() { return listaPersonajes; }
    public void setListaPersonajes(ArrayList<Personaje> listaPersonajes) { this.listaPersonajes = listaPersonajes; }
 
    public void moverPersonajeM(Personaje personaje) {
        if (!listaPersonajes.contains(personaje)) {
            listaPersonajes.add(personaje);
        }
        patio.agregarPersonaje(personaje);
        System.out.println(personaje.getNombre() + " se movió al patio de la vecindad.");
    }
 
    public Personaje buscarPersonajePorNombre(String nombre) {
        for (Personaje p : listaPersonajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) return p;
        }
        return null;
    }
 
    public Casa buscarCasaPorNumero(int num) {
        for (Casa c : listaCasas) {
            if (c.getNumero() == num) return c;
        }
        return null;
    }
}
