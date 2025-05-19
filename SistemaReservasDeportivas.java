package Reservas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Sistema que permite gestionar reservas de pistas deportivas,
 * verificando disponibilidad y gestionando la iluminación de las pistas.
 * 
 * @author Víctor Lavín García
 */
public class SistemaReservasDeportivas {

    private List<Reserva> reservas;
    private GestorIluminacion gestorIluminacion;

    /**
     * Constructor del sistema.
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        gestorIluminacion = new GestorIluminacion();
    }

    /**
     * Intenta reservar una pista usando un objeto Reserva.
     *
     * @param reserva Objeto Reserva con la información de la reserva.
     * @return true si la reserva fue exitosa, false si ya está ocupada.
     */
    public boolean reservarPista(Reserva reserva) {
        if (!esFechaDisponible(reserva.getIdPista(), reserva.getFecha())) {
            return false;
        }
        reservas.add(reserva);
        return true;
    }

    /**
     * Cancela una reserva buscando por ID de pista (no es único).
     *
     * @param idPista ID de pista.
     * @return true si fue cancelada una reserva, false si no se encontró.
     */
    public boolean cancelarReserva(int idPista) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idPista) {
                reservas.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica la disponibilidad de una pista para una fecha específica.
     *
     * @param idPista ID de la pista.
     * @param fecha Fecha de la reserva.
     * @return true si la pista está libre, false si ya está reservada.
     */
    public boolean verificarDisponibilidad(int idPista, LocalDate fecha) {
        return esFechaDisponible(idPista, fecha);
    }

    /**
     * Método privado que comprueba si una pista está disponible en una fecha.
     *
     * @param idPista ID de la pista.
     * @param fecha Fecha a verificar.
     * @return true si está disponible, false si no.
     */
    private boolean esFechaDisponible(int idPista, LocalDate fecha) {
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Encender las luces de una pista.
     *
     * @param idPista ID de la pista.
     * @return true si se encendieron, false si el ID es inválido.
     */
    public boolean encenderLuces(int idPista) {
        return gestorIluminacion.encenderLuces(idPista);
    }

    /**
     * Apagar las luces de una pista.
     *
     * @param idPista ID de la pista.
     * @return true si se apagaron, false si el ID es inválido.
     */
    public boolean apagarLuces(int idPista) {
        return gestorIluminacion.apagarLuces(idPista);
    }
}