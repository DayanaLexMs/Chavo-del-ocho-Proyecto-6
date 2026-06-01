/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Casa {
    private int numero;
    private Personaje quienVive;
 
    public Casa(int numero, Personaje quienVive) {
        this.numero = numero;
        this.quienVive = quienVive;
    }
 
    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public Personaje getQuienVive() { return quienVive; }
    public void setQuienVive(Personaje quienVive) { this.quienVive = quienVive; }
 
    public void recibirVisita(Personaje visitante) {
        System.out.println(visitante.getNombre() + " visita la casa #" + numero +
            (quienVive != null ? " de " + quienVive.getNombre() : " (vacía)"));
    }
 
    @Override
    public String toString() {
        return "Casa #" + numero + (quienVive != null ? " - " + quienVive.getNombre() : " - Vacía");
    }
}