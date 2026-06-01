/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class ObjetoInteractivo {
    protected String nombre;
    protected Tipo tipo;
    protected String ubicacion;
    protected String descripcion;
    protected boolean usoPermitido;
 
    public ObjetoInteractivo(String nombre, Tipo tipo, String ubicacion, String descripcion, boolean usoPermitido) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.usoPermitido = usoPermitido;
    }
 
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Tipo getTipo() { return tipo; }
    public void setTipo(Tipo tipo) { this.tipo = tipo; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public boolean getUsoPermitido() { return usoPermitido; }
    public void setUsoPermitido(boolean usoPermitido) { this.usoPermitido = usoPermitido; }
 
    public void usar(Personaje usuario) {
        if (usoPermitido) {
            System.out.println(usuario.getNombre() + " usa " + nombre + " (" + descripcion + ")");
        } else {
            System.out.println("¡" + usuario.getNombre() + " no puede usar " + nombre + " ahora mismo!");
        }
    }
 
    @Override
    public String toString() {
        return nombre + " [" + tipo + "] en " + ubicacion;
    }
}
