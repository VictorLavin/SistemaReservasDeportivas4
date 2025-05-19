package Reservas;

import java.time.LocalDate;

/**
 * Clase que representa una reserva de una pista deportiva.
 * Contiene la pista, la fecha y la duración de la reserva.
 * 
 * @author Víctor Lavín García
 */
public class Reserva {
    private int idPista;
    private LocalDate fecha;
    private int duracion;

    /**
     * Constructor de una reserva.
     *
     * @param idPista ID de la pista que se desea reservar.
     * @param fecha Fecha de la reserva.
     * @param duracion Duración de la reserva en horas.
     */
    public Reserva(int idPista, LocalDate fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    public int getIdPista() {
        return idPista;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getDuracion() {
        return duracion;
    }
}