/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
 
public class Patio {
    private ArrayList<ObjetoInteractivo> listaObjetos;
    private ArrayList<Personaje> listaPersonajesP;
 
    public Patio(ArrayList<ObjetoInteractivo> listaObjetos, ArrayList<Personaje> listaPersonajesP) {
        this.listaObjetos = listaObjetos != null ? listaObjetos : new ArrayList<>();
        this.listaPersonajesP = listaPersonajesP != null ? listaPersonajesP : new ArrayList<>();
    }
 
    public Patio() {
        this.listaObjetos = new ArrayList<>();
        this.listaPersonajesP = new ArrayList<>();
    }
 
    public ArrayList<ObjetoInteractivo> getListaObjetos() { return listaObjetos; }
    public void setListaObjetos(ArrayList<ObjetoInteractivo> listaObjetos) { this.listaObjetos = listaObjetos; }
    public ArrayList<Personaje> getListaPersonajesP() { return listaPersonajesP; }
    public void setListaPersonajesP(ArrayList<Personaje> listaPersonajesP) { this.listaPersonajesP = listaPersonajesP; }
 
    public void agregarPersonaje(Personaje p) {
        listaPersonajesP.add(p);
    }
 
    public void agregarObjeto(ObjetoInteractivo o) {
        listaObjetos.add(o);
    }
 
    public String getEstado() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== PATIO ===\n");
        sb.append("Personajes presentes: ").append(listaPersonajesP.size()).append("\n");
        for (Personaje p : listaPersonajesP) {
            sb.append("  - ").append(p.getNombre()).append("\n");
        }
        sb.append("Objetos disponibles: ").append(listaObjetos.size()).append("\n");
        for (ObjetoInteractivo o : listaObjetos) {
            sb.append("  - ").append(o.getNombre()).append(" [").append(o.getTipo()).append("]\n");
        }
        return sb.toString();
    }
}