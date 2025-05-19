package Reservas;

/**
 * Clase que gestiona la iluminación de las pistas deportivas.
 * Encargada de encender y apagar las luces por pista.
 * 
 * @author Víctor Lavín García
 */
public class GestorIluminacion {
    private boolean[] iluminacion;
    private static final int MAX_PISTAS = 10;

    /**
     * Constructor del gestor de iluminación.
     */
    public GestorIluminacion() {
        iluminacion = new boolean[MAX_PISTAS];
    }

    /**
     * Enciende las luces de una pista.
     *
     * @param idPista ID de la pista.
     * @return true si se encendieron, false si el ID es inválido.
     */
    public boolean encenderLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false;
        }
        iluminacion[idPista] = true;
        return true;
    }

    /**
     * Apaga las luces de una pista.
     *
     * @param idPista ID de la pista.
     * @return true si se apagaron, false si el ID es inválido.
     */
    public boolean apagarLuces(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false;
        }
        iluminacion[idPista] = false;
        return true;
    }
}