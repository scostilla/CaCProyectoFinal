// Datos de ejemplo para los oradores
const oradores = [
    { nombre: "Orador 1", temas: "Tema 1", experiencia: "Experiencia 1" },
    { nombre: "Orador 2", temas: "Tema 2", experiencia: "Experiencia 2" },
    { nombre: "Orador 3", temas: "Tema 3", experiencia: "Experiencia 3" }
];

// Función para agregar filas a la tabla
function agregarFilasATabla() {
    const tbody = document.getElementById('tbodyOradores');

    // Limpiar el contenido actual de la tabla
    tbody.innerHTML = '';

    // Iterar sobre los oradores y agregar filas
    oradores.forEach(orador => {
        const fila = `<tr>
                        <td>${orador.nombre}</td>
                        <td>${orador.apellido}</td>
                        <td>${orador.tema}</td>
                    </tr>`;
        tbody.innerHTML += fila;
    });
}

// Llamar a la función para agregar filas cuando la página se carga
window.onload = agregarFilasATabla;
