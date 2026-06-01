/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

 
import modelo.*;
import vista.VentanaPrincipal;
 
import java.util.ArrayList;
 
public class Controlador {
 
    private Vecindad vecindad;
    private VentanaPrincipal vista;
 
    public Controlador() {
        inicializarMundo();
    }
 
    public void setVista(VentanaPrincipal vista) {
        this.vista = vista;
    }
 
    // ── Inicialización del mundo ──────────────────────────────────────────────
 
    private void inicializarMundo() {
 
        // Personajes
        Chavo chavo = new Chavo("El Chavo", 8, "Inocente y buena gente", "Niño huérfano", 100, 80, "Alegre", false, true);
        DonaFlorinda florinda = new DonaFlorinda("Doña Florinda", 38, "Soberbia y exagerada", "Mamá de Quico", 100, "Altiva", true);
        DonRamon donRamon = new DonRamon("Don Ramón", 45, "Flojo pero bondadoso", "Papá de la Chilindrina", 100, "Tranquilo", 5000);
        Quico quico = new Quico("Quico", 9, "Presumido y llorón", "Amigo del Chavo", 100, "Presumido", true);
        SenorBarriga sBarriga = new SenorBarriga("Señor Barriga", 50, "Insistente y formal", "Casero", 100, "Serio", 0);
 
        // Casas
        Casa casaChavo   = new Casa(8, chavo);
        Casa casaFlorinda = new Casa(14, florinda);
        Casa casaRamon   = new Casa(72, donRamon);
        Casa casaBarriga = new Casa(1, sBarriga);
 
        ArrayList<Casa> casas = new ArrayList<>();
        casas.add(casaChavo);
        casas.add(casaFlorinda);
        casas.add(casaRamon);
        casas.add(casaBarriga);
 
        // Objetos interactivos del patio
        ObjetoInteractivo barril    = new ObjetoInteractivo("Barril del Chavo", Tipo.BARRIL,    "Patio central", "El hogar secreto del Chavo",        true);
        ObjetoInteractivo tortaJamon = new ObjetoInteractivo("Torta de Jamón",   Tipo.TORTAJAMON,"Cocina Florinda","La torta favorita del Chavo",       true);
        ObjetoInteractivo jugueteQ  = new ObjetoInteractivo("Juguete de Quico",  Tipo.JUGUETE,  "Casa de Quico",  "El juguete nuevo que Quico presume", true);
 
        // Patio
        Patio patio = new Patio();
        patio.agregarObjeto(barril);
        patio.agregarObjeto(tortaJamon);
        patio.agregarObjeto(jugueteQ);
 
        // Personajes en el patio inicialmente
        patio.agregarPersonaje(chavo);
        patio.agregarPersonaje(quico);
        patio.agregarPersonaje(florinda);
        patio.agregarPersonaje(donRamon);
        patio.agregarPersonaje(sBarriga);
 
        // Casas del Señor Barriga
        sBarriga.getListaCasasP().add(casaChavo);
        sBarriga.getListaCasasP().add(casaFlorinda);
        sBarriga.getListaCasasP().add(casaRamon);
 
        // Vecindad
        ArrayList<Personaje> personajes = new ArrayList<>();
        personajes.add(chavo);
        personajes.add(florinda);
        personajes.add(donRamon);
        personajes.add(quico);
        personajes.add(sBarriga);
 
        vecindad = new Vecindad("Vecindad del Chavo del 8", casas, patio, personajes);
    }
 
    // ── Getters para la vista ─────────────────────────────────────────────────
 
    public Vecindad getVecindad() { return vecindad; }
 
    public ArrayList<Personaje> getPersonajes() {
        return vecindad.getListaPersonajes();
    }
 
    public ArrayList<ObjetoInteractivo> getObjetos() {
        return vecindad.getPatio().getListaObjetos();
    }
 
    // ── Acciones del juego ────────────────────────────────────────────────────
 
    /**
     * Devuelve el texto del diálogo/acción del personaje.
     */
    public String ejecutarAccion(String nombrePersonaje) {
        Personaje p = vecindad.buscarPersonajePorNombre(nombrePersonaje);
        if (p == null) return "Personaje no encontrado.";
 
        StringBuilder sb = new StringBuilder();
        sb.append("── Acción de ").append(p.getNombre()).append(" ──\n");
 
        if (p instanceof Chavo c) {
            c.pedirTortaJamon();
            sb.append("\"¡Una torta de jamón, por favor!\"");
        } else if (p instanceof DonaFlorinda f) {
            f.darTortaJamon();
            sb.append("\"¡Tome su torta... y no me moleste más!\"");
        } else if (p instanceof DonRamon r) {
            r.esconderseCasa();
            sb.append("\"¡Shhh! Que viene el Señor Barriga...\"");
        } else if (p instanceof Quico q) {
            q.acusarMama();
            sb.append("\"¡Mamáaaaa! ¡El Chavo me pegó!\"");
        } else if (p instanceof SenorBarriga sb2) {
            sb2.cobrarRenta();
            sb.append("\"¡Don Ramón! ¡La renta! ¡Ya van 3 meses!\"");
        }
 
        return sb.toString();
    }
 
    /**
     * Simula una interacción entre dos personajes y devuelve el relato.
     */
    public String interactuar(String nombreP1, String nombreP2) {
        Personaje p1 = vecindad.buscarPersonajePorNombre(nombreP1);
        Personaje p2 = vecindad.buscarPersonajePorNombre(nombreP2);
 
        if (p1 == null || p2 == null) return "Uno o ambos personajes no fueron encontrados.";
 
        StringBuilder sb = new StringBuilder();
        sb.append("🎭 Interacción: ").append(p1.getNombre()).append(" → ").append(p2.getNombre()).append("\n\n");
 
        // Chavo pide torta a Florinda
        if (p1 instanceof Chavo && p2 instanceof DonaFlorinda f) {
            sb.append("Chavo: \"¡Doña Florinda, ¿me da una torta de jamón?!\"\n");
            if (f.getTieneTorta()) {
                f.setTieneTorta(false);
                ((Chavo) p1).setHambre(Math.max(0, ((Chavo) p1).getHambre() - 30));
                sb.append("Doña Florinda: \"Tome, Chavito... pero no pida más.\"\n");
                sb.append("✅ ¡El Chavo recibió su torta de jamón! Su hambre bajó.");
            } else {
                sb.append("Doña Florinda: \"¡No tengo torta! ¡Quico, dile que se vaya!\"\n");
                sb.append("❌ No había torta disponible.");
            }
 
        // Quico golpea al Chavo
        } else if (p1 instanceof Quico q && p2 instanceof Chavo) {
            q.golpearPersonaje(p2);
            sb.append("Quico: \"¡Toma eso, Chavo!\"\n");
            sb.append("Chavo: \"¡Buaaaa! ¡Fue sin querer queriendo!\"\n");
            sb.append("⚡ Quico golpeó al Chavo. Energía del Chavo: ").append(p2.getEnergia());
 
        // Don Ramón huye del Señor Barriga
        } else if (p1 instanceof DonRamon r && p2 instanceof SenorBarriga) {
            r.esconderseCasa();
            sb.append("Sr. Barriga: \"¡Don Ramón! ¡La renta!\"\n");
            sb.append("Don Ramón: \"(susurrando) ¡Shhh, Chavo! ¡No digas que estoy aquí!\"\n");
            sb.append("🏃 Don Ramón se esconde. Deuda actual: $").append(r.getDeudaRenta());
 
        // Señor Barriga cobra renta
        } else if (p1 instanceof SenorBarriga sb2 && p2 instanceof DonRamon r) {
            sb2.cobrarRenta();
            sb.append("Sr. Barriga: \"¡Don Ramón! Son ").append(r.getDeudaRenta()).append(" pesos de renta atrasada!\"\n");
            sb.append("Don Ramón: \"¡Ay, señor Barriga, es que... el dinero no me alcanzó!\"\n");
            sb.append("💸 El Señor Barriga intentó cobrar la renta.");
 
        // Florinda regaña a Don Ramón
        } else if (p1 instanceof DonaFlorinda f2 && p2 instanceof DonRamon) {
            f2.pegar();
            p2.recibirGolpe();
            sb.append("Doña Florinda: \"¡Malcriado! ¡Eso le pasa por meterse con mi Quico!\"\n");
            sb.append("Don Ramón: \"¡Ay! ¿Por qué me pega si ni hice nada?!\"\n");
            sb.append("👜 Doña Florinda golpeó a Don Ramón. Energía de Don Ramón: ").append(p2.getEnergia());
 
        } else {
            sb.append(p1.getNombre()).append(": \"¡Hola, ").append(p2.getNombre()).append("!\"\n");
            sb.append(p2.getNombre()).append(": \"¡Hola!\"\n");
            sb.append("👋 Interacción amistosa completada.");
        }
 
        return sb.toString();
    }
 
    /**
     * Usa un objeto interactivo con el personaje indicado.
     */
    public String usarObjeto(String nombrePersonaje, String nombreObjeto) {
        Personaje p = vecindad.buscarPersonajePorNombre(nombrePersonaje);
        if (p == null) return "Personaje no encontrado.";
 
        ObjetoInteractivo obj = null;
        for (ObjetoInteractivo o : vecindad.getPatio().getListaObjetos()) {
            if (o.getNombre().equalsIgnoreCase(nombreObjeto)) { obj = o; break; }
        }
        if (obj == null) return "Objeto no encontrado.";
 
        StringBuilder sb = new StringBuilder();
        sb.append("🎮 ").append(p.getNombre()).append(" interactúa con: ").append(obj.getNombre()).append("\n\n");
 
        if (obj.getTipo() == Tipo.BARRIL && p instanceof Chavo c) {
            c.esconderseBanil();
            sb.append("El Chavo se mete al barril.\n\"¡Este es mi castillo!\"");
        } else if (obj.getTipo() == Tipo.TORTAJAMON) {
            if (p instanceof Chavo c2) {
                c2.setHambre(Math.max(0, c2.getHambre() - 20));
                sb.append("El Chavo mordió la torta de jamón.\nHambre actual: ").append(c2.getHambre());
            } else {
                sb.append(p.getNombre()).append(" prueba la torta de jamón.\n\"¡Está deliciosa!\"");
            }
        } else if (obj.getTipo() == Tipo.JUGUETE && p instanceof Quico q) {
            sb.append(q.getNombre()).append(": \"¡Miren mi juguete nuevo!\"\n\"¡Chavo no puede tocarlo porque es mío!\"");
        } else {
            obj.usar(p);
            sb.append(p.getNombre()).append(" usó ").append(obj.getNombre()).append(" exitosamente.");
        }
 
        return sb.toString();
    }
 
    /**
     * Devuelve el estado actual de la vecindad como texto.
     */
    public String getEstadoVecindad() {
        StringBuilder sb = new StringBuilder();
        sb.append("🏘️ ").append(vecindad.getNombre()).append("\n");
        sb.append("═══════════════════════════════════════\n\n");
 
        sb.append("👥 PERSONAJES:\n");
        for (Personaje p : vecindad.getListaPersonajes()) {
            sb.append("  • ").append(p.getNombre())
              .append(" | Energía: ").append(p.getEnergia())
              .append(" | Emoción: ").append(p.getEmocion()).append("\n");
            if (p instanceof Chavo c)
                sb.append("    Hambre: ").append(c.getHambre()).append("\n");
            if (p instanceof DonRamon r)
                sb.append("    Deuda renta: $").append(r.getDeudaRenta()).append("\n");
        }
 
        sb.append("\n🏠 CASAS:\n");
        for (Casa c : vecindad.getListaCasas()) {
            sb.append("  • ").append(c).append("\n");
        }
 
        sb.append("\n📦 OBJETOS EN EL PATIO:\n");
        for (ObjetoInteractivo o : vecindad.getPatio().getListaObjetos()) {
            sb.append("  • ").append(o).append("\n");
        }
 
        return sb.toString();
    }
 
    /**
     * Obtiene el diálogo característico de un personaje.
     */
    public String getDialogo(String nombrePersonaje) {
        return switch (nombrePersonaje) {
            case "El Chavo"       -> "\"¡Fue sin querer queriendo!\"";
            case "Doña Florinda"  -> "\"¡Señor Barriga! ¡Le voy a contar a mi Quico!\"";
            case "Don Ramón"      -> "\"¡Niño, ¿qué le pasa a usted?!\"";
            case "Quico"          -> "\"¡Cállate, cállate, que me desesperas!\"";
            case "Señor Barriga"  -> "\"¡Don Ramón! ¡La renta, Don Ramón!\"";
            default               -> "...";
        };
    }
}
