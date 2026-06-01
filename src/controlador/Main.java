/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import controlador.Controlador;
import vista.VentanaPrincipal;
 
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
 
/**
 * Clase principal – punto de entrada del juego El Chavo del 8.
 * Sigue el patrón MVC: instancia el Controlador y lo conecta con la Vista.
 */
public class Main {
    public static void main(String[] args) {
        // Aplicar look & feel del sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // Si falla, Swing usa su L&F por defecto
        }
 
        // Lanzar la interfaz en el Event Dispatch Thread de Swing
        SwingUtilities.invokeLater(() -> {
            Controlador controlador = new Controlador();
            VentanaPrincipal ventana = new VentanaPrincipal(controlador);
            controlador.setVista(ventana);
            ventana.setVisible(true);
        });
    }
}
