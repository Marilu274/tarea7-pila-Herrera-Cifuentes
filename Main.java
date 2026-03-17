// ============================================================
// USS Algoritmo — Sistema de Bitácora de Eventos
// Oficial de Sistemas: implementación de Pila (Stack)
// ============================================================

// ── Parte 1: TDA BitacoraStack ────────────────────────────
class BitacoraStack {

    // Nodo interno de la pila (lista enlazada)
    private static class Nodo {
        String evento;
        Nodo siguiente;

        Nodo(String evento, Nodo siguiente) {
            this.evento = evento;
            this.siguiente = siguiente;
        }
    }

    private Nodo cima;   // tope de la pila
    private int tamaño;  // cantidad de elementos

    /** Construye una bitácora vacía. */
    public BitacoraStack() {
        cima = null;
        tamaño = 0;
    }

    /**
     * registrar(String evento) — push
     * Agrega un nuevo evento a la cima de la bitácora.
     */
    public void registrar(String evento) {
        cima = new Nodo(evento, cima);
        tamaño++;
    }

    /**
     * consultarUltimo() — peek / top
     * Devuelve el último evento sin eliminarlo.
     * @throws IllegalStateException si la bitácora está vacía.
     */
    public String consultarUltimo() {
        if (estaVacia()) {
            throw new IllegalStateException(
                "⚠️  ERROR: La bitácora está vacía. No hay eventos que consultar.");
        }
        return cima.evento;
    }

    /**
     * eliminarUltimo() — pop
     * Elimina y devuelve el último evento registrado.
     * @throws IllegalStateException si la bitácora está vacía.
     */
    public String eliminarUltimo() {
        if (estaVacia()) {
            throw new IllegalStateException(
                "⚠️  ERROR: La bitácora está vacía. No hay eventos que eliminar.");
        }
        String evento = cima.evento;
        cima = cima.siguiente;
        tamaño--;
        return evento;
    }

    /**
     * estaVacia() — isEmpty
     * Retorna true si no hay eventos registrados.
     */
    public boolean estaVacia() {
        return tamaño == 0;
    }

    /**
     * totalEventos() — size
     * Retorna el número de eventos actuales.
     */
    public int totalEventos() {
        return tamaño;
    }
}

// ── Main: Misión USS Algoritmo ────────────────────────────
public class Main {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║       USS ALGORITMO — BITÁCORA DE EVENTOS        ║");
        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.println();

        BitacoraStack bitacora = new BitacoraStack();

        // ── Paso 1: Registrar los 6 eventos ──────────────
        System.out.println("► Registrando eventos de la misión...");
        bitacora.registrar("Motor de estribor encendido");
        bitacora.registrar("Velocidad warp alcanzada");
        bitacora.registrar("Señal de comunicación estable");
        bitacora.registrar("Anomalía detectada en sector 7");
        bitacora.registrar("Escudos al 40%");
        bitacora.registrar("ERROR CRÍTICO: fallo en sistema de navegación");
        System.out.println("   " + bitacora.totalEventos() + " eventos registrados.\n");

        // ── Paso 2: Consultar el último evento ────────────
        String ultimoEvento = bitacora.consultarUltimo();
        System.out.println("► Último evento registrado:");
        System.out.println("   [CIMA] " + ultimoEvento);
        System.out.println();

        // ── Paso 3: Protocolo de revisión si hay ERROR ────
        if (ultimoEvento.contains("ERROR")) {
            System.out.println("🚨 ALERTA: Se detectó un ERROR crítico.");
            System.out.println("   Iniciando protocolo de revisión: eliminando últimos 3 eventos...\n");

            for (int i = 1; i <= 3; i++) {
                String removido = bitacora.eliminarUltimo();
                System.out.println("   [REMOVIDO " + i + "] " + removido);
            }
            System.out.println();
        }

        // ── Paso 4: Estado actual de la bitácora ─────────
        System.out.println("► Estado actual de la bitácora:");
        System.out.println("   Total de eventos restantes : " + bitacora.totalEventos());
        System.out.println("   Evento en la cima          : " + bitacora.consultarUltimo());
        System.out.println();

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║               FIN DEL REPORTE                   ║");
        System.out.println("╚══════════════════════════════════════════════════╝");

        /*
         * ── Parte 3: Reflexión ─────────────────────────────────────────────
         * Una Pila es ideal porque el acceso siempre es por la cima (LIFO),
         * garantizando que el evento MÁS RECIENTE se consulte primero, tal
         * como lo exige el protocolo de emergencia del capitán. Con una lista
         * normal accedida por índice habría que recalcular el último índice
         * (size-1) en cada operación, exponiendo el sistema a errores de
         * índice fuera de rango y rompiendo la abstracción del TDA.
         */
    }
}