// buyTickets.js

// Datos de ejemplo para los tickets vendidos
const ticketsVendidos = [
    { id: 1, nombre: "Nombre1", apellido: "Apellido1", cantidad: 2, categoria: "Estudiante" },
    { id: 2, nombre: "Nombre2", apellido: "Apellido2", cantidad: 1, categoria: "Trainee" },
    // Agrega más datos si es necesario
];

// Función para agregar filas a la tabla de tickets vendidos
function agregarFilasATabla() {
    const tbody = document.getElementById('tbodyTickets');

    // Limpiar el contenido actual de la tabla
    tbody.innerHTML = '';

    // Iterar sobre los tickets vendidos y agregar filas
    ticketsVendidos.forEach(ticket => {
        const fila = `<tr>
                        <td>${ticket.id}</td>
                        <td>${ticket.nombre}</td>
                        <td>${ticket.apellido}</td>
                        <td>${ticket.cantidad}</td>
                        <td>${ticket.categoria}</td>
                    </tr>`;
        tbody.innerHTML += fila;
    });
}

// Llamar a la función para agregar filas cuando la página se carga
window.onload = agregarFilasATabla;
