/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author USUARIO
 */
public class ObjetoInteractivo {
    
    protected String nombre;
    protected String ubicacion;
    protected String descripcion;
    protected boolean usoPermitido;

    public ObjetoInteractivo() {
    }

    public ObjetoInteractivo(String nombre, String ubicacion, String descripcion, boolean usoPermitido) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.usoPermitido = usoPermitido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isUsoPermitido() {
        return usoPermitido;
    }

    public void setUsoPermitido(boolean usoPermitido) {
        this.usoPermitido = usoPermitido;
    }
    
    
    
}
