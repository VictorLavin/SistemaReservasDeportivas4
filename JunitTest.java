package Reservas;

import static org.junit.jupiter.api.Assertions.*;

import Reservas.Reserva;
import Reservas.SistemaReservasDeportivas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class JunitTest {

    private SistemaReservasDeportivas sistema;

    @BeforeEach
    void setUp() {
        sistema = new SistemaReservasDeportivas();
    }

    // -------------------------------
    // TESTS PARA RESERVAS DE PISTA
    // -------------------------------

    @Test
    void testReservarPistaDisponible() {
        Reserva reserva = new Reserva(1, LocalDate.of(2025, 6, 1), 2);
        boolean resultado = sistema.reservarPista(reserva);
        assertTrue(resultado, "Debería permitir reservar una pista disponible");
    }

    @Test
    void testReservarPistaYaOcupada() {
        LocalDate fecha = LocalDate.of(2025, 6, 1);
        Reserva reserva1 = new Reserva(1, fecha, 2);
        Reserva reserva2 = new Reserva(1, fecha, 1);
        sistema.reservarPista(reserva1);
        boolean resultado = sistema.reservarPista(reserva2);
        assertFalse(resultado, "No debería permitir reservar una pista ya ocupada en esa fecha");
    }

    @Test
    void testReservarPistasDistintasMismaFecha() {
        LocalDate fecha = LocalDate.of(2025, 6, 1);
        Reserva reserva1 = new Reserva(1, fecha, 2);
        Reserva reserva2 = new Reserva(2, fecha, 1);
        sistema.reservarPista(reserva1);
        boolean resultado = sistema.reservarPista(reserva2);
        assertTrue(resultado, "Debería permitir reservar distintas pistas en la misma fecha");
    }

    // -------------------------------
    // TESTS PARA CANCELAR RESERVA
    // -------------------------------

    @Test
    void testCancelarReservaExistente() {
        Reserva reserva = new Reserva(3, LocalDate.of(2025, 6, 2), 1);
        sistema.reservarPista(reserva);
        boolean resultado = sistema.cancelarReserva(3);
        assertTrue(resultado, "Debería cancelar una reserva existente");
    }

    @Test
    void testCancelarReservaInexistente() {
        boolean resultado = sistema.cancelarReserva(999);
        assertFalse(resultado, "No debería cancelar una reserva inexistente");
    }

    // -------------------------------
    // TESTS PARA DISPONIBILIDAD
    // -------------------------------

    @Test
    void testVerificarDisponibilidadPistaLibre() {
        LocalDate fecha = LocalDate.of(2025, 6, 3);
        boolean disponible = sistema.verificarDisponibilidad(4, fecha);
        assertTrue(disponible, "La pista debería estar disponible si no hay reservas");
    }

    @Test
    void testVerificarDisponibilidadPistaOcupada() {
        LocalDate fecha = LocalDate.of(2025, 6, 4);
        sistema.reservarPista(new Reserva(5, fecha, 1));
        boolean disponible = sistema.verificarDisponibilidad(5, fecha);
        assertFalse(disponible, "La pista no debería estar disponible si ya está reservada en esa fecha");
    }

    // -------------------------------
    // TESTS PARA ILUMINACIÓN
    // -------------------------------

    @Test
    void testEncenderLucesPistaValida() {
        boolean encendido = sistema.encenderLuces(2);
        assertTrue(encendido, "Debería encender luces para pista válida");
    }

    @Test
    void testApagarLucesPistaEncendida() {
        sistema.encenderLuces(2);
        boolean apagado = sistema.apagarLuces(2);
        assertTrue(apagado, "Debería apagar luces que estaban encendidas");
    }

    @Test
    void testEncenderLucesIdInvalido() {
        boolean encendido = sistema.encenderLuces(20);
        assertFalse(encendido, "No debería encender luces con ID inválido");
    }

    @Test
    void testApagarLucesIdInvalido() {
        boolean apagado = sistema.apagarLuces(-1);
        assertFalse(apagado, "No debería apagar luces con ID inválido");
    }

    @Test
    void testApagarLucesSinEncender() {
        boolean apagado = sistema.apagarLuces(4);
        assertTrue(apagado, "Debería devolver true aunque no se haya encendido previamente, porque se considera válida");
    }
}
