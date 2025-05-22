package Reservas;

public class ComentariosJavadoc {
	<!DOCTYPE html>
	<html lang="es">
	<head>
	    <meta charset="UTF-8">
	    <title>SistemaReservasDeportivas (JavaDoc)</title>
	    <style>
	        body { font-family: Arial, sans-serif; margin: 20px; }
	        table { border-collapse: collapse; width: 100%; margin-bottom: 20px; }
	        th, td { border: 1px solid #ccc; padding: 8px; }
	        th { background-color: #f2f2f2; }
	        h1, h2, h3 { color: #333; }
	        code { background-color: #eee; padding: 2px 4px; }
	    </style>
	</head>
	<body>

	    <h1>Paquete Reservas</h1>

	    <h2>Resumen de Clases</h2>
	    <table>
	        <tr><th>Clase</th><th>Descripción</th></tr>
	        <tr><td><a href="#GestorIluminacion">GestorIluminacion</a></td><td>Gestiona el encendido y apagado de la iluminación de las pistas.</td></tr>
	        <tr><td><a href="#Reserva">Reserva</a></td><td>Representa una reserva de una pista deportiva.</td></tr>
	        <tr><td><a href="#SistemaReservasDeportivas">SistemaReservasDeportivas</a></td><td>Permite gestionar reservas y control de iluminación.</td></tr>
	    </table>

	    <h2 id="SistemaReservasDeportivas">Clase SistemaReservasDeportivas</h2>
	    <p><strong>Descripción:</strong> Sistema que permite gestionar reservas de pistas deportivas, verificar disponibilidad y controlar la iluminación.</p>

	    <h3>Resumen de Constructores</h3>
	    <table>
	        <tr><th>Constructor</th><th>Descripción</th></tr>
	        <tr><td><code>SistemaReservasDeportivas()</code></td><td>Inicializa la lista de reservas y el gestor de iluminación.</td></tr>
	    </table>

	    <h3>Resumen de Métodos</h3>
	    <table>
	        <tr><th>Tipo</th><th>Método</th><th>Descripción</th></tr>
	        <tr><td>boolean</td><td><code>reservarPista(Reserva reserva)</code></td><td>Registra una nueva reserva si la fecha está disponible.</td></tr>
	        <tr><td>boolean</td><td><code>cancelarReserva(int idPista)</code></td><td>Cancela la primera reserva encontrada para una pista.</td></tr>
	        <tr><td>boolean</td><td><code>verificarDisponibilidad(int idPista, LocalDate fecha)</code></td><td>Devuelve true si la pista está libre ese día.</td></tr>
	        <tr><td>boolean</td><td><code>encenderLuces(int idPista)</code></td><td>Enciende las luces de la pista indicada.</td></tr>
	        <tr><td>boolean</td><td><code>apagarLuces(int idPista)</code></td><td>Apaga las luces de la pista indicada.</td></tr>
	    </table>

	</body>
	</html>

}
