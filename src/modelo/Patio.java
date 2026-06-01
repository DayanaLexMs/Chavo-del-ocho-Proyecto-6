/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Patio {
    
    private ArrayList <ObjetoInteractivo> objetos;
    private ArrayList <Personaje> listaPersonajes;

    public Patio() {
    }

    public Patio(ArrayList<ObjetoInteractivo> objetos, ArrayList<Personaje> listaPersonajes) {
        this.objetos = objetos;
        this.listaPersonajes = listaPersonajes;
    }

    public ArrayList<ObjetoInteractivo> getObjetos() {
        return objetos;
    }

    public void setObjetos(ArrayList<ObjetoInteractivo> objetos) {
        this.objetos = objetos;
    }

    public ArrayList<Personaje> getListaPersonajes() {
        return listaPersonajes;
    }

    public void setListaPersonajes(ArrayList<Personaje> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }
    
    
    
}
