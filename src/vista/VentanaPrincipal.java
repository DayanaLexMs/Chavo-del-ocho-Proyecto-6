/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.Controlador;
import modelo.*;
 
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
 
/**
 * VentanaPrincipal – Vista principal del juego El Chavo del 8.
 * Diseñada manualmente con el mismo estilo que genera el GUI Builder de NetBeans.
 */
public class VentanaPrincipal extends JFrame {
 
    // ── Colores del tema ──────────────────────────────────────────────────────
    private static final Color COLOR_FONDO       = new Color(255, 243, 205);
    private static final Color COLOR_PANEL       = new Color(255, 228, 132);
    private static final Color COLOR_HEADER      = new Color(204, 85, 0);
    private static final Color COLOR_BTN_ACCION  = new Color(220, 100, 30);
    private static final Color COLOR_BTN_INTER   = new Color(60, 140, 60);
    private static final Color COLOR_BTN_OBJETO  = new Color(50, 100, 180);
    private static final Color COLOR_BTN_ESTADO  = new Color(120, 60, 160);
    private static final Color COLOR_TEXTO       = new Color(60, 30, 0);
    private static final Color COLOR_LOG         = new Color(30, 20, 10);
 
    // ── Componentes de la UI ──────────────────────────────────────────────────
    private JPanel      pnlPrincipal;
    private JPanel      pnlHeader;
    private JLabel      lblTitulo;
    private JLabel      lblSubtitulo;
 
    private JPanel      pnlIzquierda;
    private JLabel      lblPersonaje1;
    private JComboBox<String> cmbPersonaje1;
    private JLabel      lblPersonaje2;
    private JComboBox<String> cmbPersonaje2;
    private JLabel      lblObjeto;
    private JComboBox<String> cmbObjeto;
 
    private JPanel      pnlBotones;
    private JButton     btnAccion;
    private JButton     btnInteractuar;
    private JButton     btnUsarObjeto;
    private JButton     btnEstado;
    private JButton     btnDialogo;
    private JButton     btnReiniciar;
 
    private JPanel      pnlLog;
    private JLabel      lblLog;
    private JTextArea   txtLog;
    private JScrollPane scrollLog;
 
    private JPanel      pnlStatus;
    private JLabel      lblStatusPersonajes;
 
    // ── Referencia al controlador ─────────────────────────────────────────────
    private final Controlador controlador;
 
    // ── Constructor ───────────────────────────────────────────────────────────
    public VentanaPrincipal(Controlador controlador) {
        this.controlador = controlador;
        initComponents();
        cargarDatos();
        setLocationRelativeTo(null);
    }
 
    // ── Inicialización de componentes (estilo NetBeans) ───────────────────────
    private void initComponents() {
        setTitle("El Chavo del 8 – Videojuego Interactivo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 680);
        setResizable(true);
        setMinimumSize(new Dimension(800, 600));
 
        // ── Panel principal ──────────────────────────────────────────────────
        pnlPrincipal = new JPanel(new BorderLayout(0, 0));
        pnlPrincipal.setBackground(COLOR_FONDO);
        setContentPane(pnlPrincipal);
 
        // ── HEADER ──────────────────────────────────────────────────────────
        pnlHeader = new JPanel();
        pnlHeader.setBackground(COLOR_HEADER);
        pnlHeader.setLayout(new BoxLayout(pnlHeader, BoxLayout.Y_AXIS));
        pnlHeader.setBorder(new EmptyBorder(12, 20, 12, 20));
 
        lblTitulo = new JLabel("🏘️  El Chavo del 8  🏘️");
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 26));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
 
        lblSubtitulo = new JLabel("Videojuego interactivo de la famosa vecindad");
        lblSubtitulo.setFont(new Font("SansSerif", Font.ITALIC, 13));
        lblSubtitulo.setForeground(new Color(255, 220, 160));
        lblSubtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
 
        pnlHeader.add(lblTitulo);
        pnlHeader.add(Box.createVerticalStrut(4));
        pnlHeader.add(lblSubtitulo);
        pnlPrincipal.add(pnlHeader, BorderLayout.NORTH);
 
        // ── PANEL CENTRAL (izquierda + log) ──────────────────────────────────
        JPanel pnlCentro = new JPanel(new BorderLayout(10, 0));
        pnlCentro.setBackground(COLOR_FONDO);
        pnlCentro.setBorder(new EmptyBorder(12, 12, 6, 12));
        pnlPrincipal.add(pnlCentro, BorderLayout.CENTER);
 
        // ── PANEL IZQUIERDA ──────────────────────────────────────────────────
        pnlIzquierda = new JPanel();
        pnlIzquierda.setLayout(new BoxLayout(pnlIzquierda, BoxLayout.Y_AXIS));
        pnlIzquierda.setBackground(COLOR_PANEL);
        pnlIzquierda.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(COLOR_HEADER, 2, true),
            new EmptyBorder(14, 14, 14, 14)
        ));
        pnlIzquierda.setPreferredSize(new Dimension(230, 0));
 
        agregarSeparador(pnlIzquierda, "🎭 Selección");
 
        lblPersonaje1 = crearLabel("Personaje 1 (actor):");
        cmbPersonaje1 = new JComboBox<>();
        estilizarCombo(cmbPersonaje1);
 
        lblPersonaje2 = crearLabel("Personaje 2 (receptor):");
        cmbPersonaje2 = new JComboBox<>();
        estilizarCombo(cmbPersonaje2);
 
        lblObjeto = crearLabel("Objeto interactivo:");
        cmbObjeto = new JComboBox<>();
        estilizarCombo(cmbObjeto);
 
        pnlIzquierda.add(lblPersonaje1);
        pnlIzquierda.add(Box.createVerticalStrut(4));
        pnlIzquierda.add(cmbPersonaje1);
        pnlIzquierda.add(Box.createVerticalStrut(12));
        pnlIzquierda.add(lblPersonaje2);
        pnlIzquierda.add(Box.createVerticalStrut(4));
        pnlIzquierda.add(cmbPersonaje2);
        pnlIzquierda.add(Box.createVerticalStrut(12));
        pnlIzquierda.add(lblObjeto);
        pnlIzquierda.add(Box.createVerticalStrut(4));
        pnlIzquierda.add(cmbObjeto);
        pnlIzquierda.add(Box.createVerticalStrut(20));
 
        // ── BOTONES ──────────────────────────────────────────────────────────
        agregarSeparador(pnlIzquierda, "⚡ Acciones");
 
        btnAccion     = crearBoton("Ejecutar Acción",    COLOR_BTN_ACCION);
        btnInteractuar = crearBoton("Interactuar",       COLOR_BTN_INTER);
        btnUsarObjeto = crearBoton("Usar Objeto",        COLOR_BTN_OBJETO);
        btnDialogo    = crearBoton("Ver Diálogo",        new Color(160, 100, 0));
        btnEstado     = crearBoton("Estado Vecindad",    COLOR_BTN_ESTADO);
        btnReiniciar  = crearBoton("🔄 Reiniciar Juego", new Color(100, 100, 100));
 
        pnlIzquierda.add(btnAccion);
        pnlIzquierda.add(Box.createVerticalStrut(8));
        pnlIzquierda.add(btnInteractuar);
        pnlIzquierda.add(Box.createVerticalStrut(8));
        pnlIzquierda.add(btnUsarObjeto);
        pnlIzquierda.add(Box.createVerticalStrut(8));
        pnlIzquierda.add(btnDialogo);
        pnlIzquierda.add(Box.createVerticalStrut(8));
        pnlIzquierda.add(btnEstado);
        pnlIzquierda.add(Box.createVerticalStrut(14));
        pnlIzquierda.add(btnReiniciar);
        pnlIzquierda.add(Box.createVerticalGlue());
 
        pnlCentro.add(pnlIzquierda, BorderLayout.WEST);
 
        // ── PANEL DE LOG ─────────────────────────────────────────────────────
        pnlLog = new JPanel(new BorderLayout(0, 6));
        pnlLog.setBackground(COLOR_FONDO);
 
        lblLog = new JLabel("📜  Registro de eventos:");
        lblLog.setFont(new Font("SansSerif", Font.BOLD, 13));
        lblLog.setForeground(COLOR_TEXTO);
 
        txtLog = new JTextArea();
        txtLog.setFont(new Font("Monospaced", Font.PLAIN, 13));
        txtLog.setBackground(new Color(30, 20, 10));
        txtLog.setForeground(new Color(255, 220, 120));
        txtLog.setCaretColor(Color.WHITE);
        txtLog.setEditable(false);
        txtLog.setLineWrap(true);
        txtLog.setWrapStyleWord(true);
        txtLog.setMargin(new Insets(10, 12, 10, 12));
        txtLog.setText("¡Bienvenido a la Vecindad del Chavo del 8!\n" +
                       "Selecciona personajes y acciones para comenzar.\n\n" +
                       "¿Qué esperas? ¡A jugar!\n");
 
        scrollLog = new JScrollPane(txtLog);
        scrollLog.setBorder(new LineBorder(COLOR_HEADER, 2, true));
        scrollLog.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
 
        pnlLog.add(lblLog, BorderLayout.NORTH);
        pnlLog.add(scrollLog, BorderLayout.CENTER);
        pnlCentro.add(pnlLog, BorderLayout.CENTER);
 
        // ── BARRA DE ESTADO ──────────────────────────────────────────────────
        pnlStatus = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 4));
        pnlStatus.setBackground(new Color(180, 100, 20));
        pnlStatus.setBorder(new EmptyBorder(2, 8, 2, 8));
 
        lblStatusPersonajes = new JLabel("Vecindad cargada | 5 personajes activos");
        lblStatusPersonajes.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblStatusPersonajes.setForeground(Color.WHITE);
        pnlStatus.add(lblStatusPersonajes);
 
        pnlPrincipal.add(pnlStatus, BorderLayout.SOUTH);
 
        // ── Event listeners ──────────────────────────────────────────────────
        btnAccion.addActionListener(e -> onAccion());
        btnInteractuar.addActionListener(e -> onInteractuar());
        btnUsarObjeto.addActionListener(e -> onUsarObjeto());
        btnDialogo.addActionListener(e -> onDialogo());
        btnEstado.addActionListener(e -> onEstado());
        btnReiniciar.addActionListener(e -> onReiniciar());
    }
 
    // ── Carga de datos en los combos ──────────────────────────────────────────
    private void cargarDatos() {
        ArrayList<Personaje> personajes = controlador.getPersonajes();
        for (Personaje p : personajes) {
            cmbPersonaje1.addItem(p.getNombre());
            cmbPersonaje2.addItem(p.getNombre());
        }
        if (cmbPersonaje2.getItemCount() > 1) cmbPersonaje2.setSelectedIndex(1);
 
        ArrayList<ObjetoInteractivo> objetos = controlador.getObjetos();
        for (ObjetoInteractivo o : objetos) {
            cmbObjeto.addItem(o.getNombre());
        }
 
        actualizarStatus();
    }
 
    // ── Handlers ─────────────────────────────────────────────────────────────
    private void onAccion() {
        String nombre = (String) cmbPersonaje1.getSelectedItem();
        if (nombre == null) return;
        String resultado = controlador.ejecutarAccion(nombre);
        appendLog("⚡ ACCIÓN\n" + resultado);
        actualizarStatus();
    }
 
    private void onInteractuar() {
        String p1 = (String) cmbPersonaje1.getSelectedItem();
        String p2 = (String) cmbPersonaje2.getSelectedItem();
        if (p1 == null || p2 == null) return;
        if (p1.equals(p2)) {
            JOptionPane.showMessageDialog(this, "Selecciona personajes distintos.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String resultado = controlador.interactuar(p1, p2);
        appendLog("🎭 INTERACCIÓN\n" + resultado);
        actualizarStatus();
    }
 
    private void onUsarObjeto() {
        String nombre = (String) cmbPersonaje1.getSelectedItem();
        String objeto = (String) cmbObjeto.getSelectedItem();
        if (nombre == null || objeto == null) return;
        String resultado = controlador.usarObjeto(nombre, objeto);
        appendLog("🎮 USAR OBJETO\n" + resultado);
    }
 
    private void onDialogo() {
        String nombre = (String) cmbPersonaje1.getSelectedItem();
        if (nombre == null) return;
        String dialogo = controlador.getDialogo(nombre);
        appendLog("💬 DIÁLOGO de " + nombre + "\n" + dialogo);
    }
 
    private void onEstado() {
        String estado = controlador.getEstadoVecindad();
        appendLog(estado);
    }
 
    private void onReiniciar() {
        int confirm = JOptionPane.showConfirmDialog(this,
            "¿Reiniciar el juego? Se perderá el progreso actual.",
            "Confirmar reinicio", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            txtLog.setText("🔄 Juego reiniciado.\n¡Bienvenido de nuevo a la vecindad!\n\n");
            actualizarStatus();
        }
    }
 
    // ── Helpers ───────────────────────────────────────────────────────────────
    private void appendLog(String texto) {
        txtLog.append("\n─────────────────────────────────────\n");
        txtLog.append(texto + "\n");
        txtLog.setCaretPosition(txtLog.getDocument().getLength());
    }
 
    private void actualizarStatus() {
        int total = controlador.getPersonajes().size();
        lblStatusPersonajes.setText("Vecindad activa | " + total + " personajes | Listo");
    }
 
    private JLabel crearLabel(String texto) {
        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("SansSerif", Font.BOLD, 12));
        lbl.setForeground(COLOR_TEXTO);
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        return lbl;
    }
 
    private void estilizarCombo(JComboBox<String> cmb) {
        cmb.setFont(new Font("SansSerif", Font.PLAIN, 12));
        cmb.setBackground(Color.WHITE);
        cmb.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        cmb.setAlignmentX(Component.LEFT_ALIGNMENT);
    }
 
    private JButton crearBoton(String texto, Color color) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("SansSerif", Font.BOLD, 12));
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
 
        btn.addMouseListener(new MouseAdapter() {
            final Color original = color;
            @Override public void mouseEntered(MouseEvent e) {
                btn.setBackground(original.brighter());
            }
            @Override public void mouseExited(MouseEvent e) {
                btn.setBackground(original);
            }
        });
        return btn;
    }
 
    private void agregarSeparador(JPanel panel, String titulo) {
        JLabel lbl = new JLabel(titulo);
        lbl.setFont(new Font("SansSerif", Font.BOLD, 13));
        lbl.setForeground(COLOR_HEADER);
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        panel.add(lbl);
        panel.add(Box.createVerticalStrut(6));
        JSeparator sep = new JSeparator();
        sep.setForeground(COLOR_HEADER);
        sep.setMaximumSize(new Dimension(Integer.MAX_VALUE, 2));
        panel.add(sep);
        panel.add(Box.createVerticalStrut(10));
    }
}
