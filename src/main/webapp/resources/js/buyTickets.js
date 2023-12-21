const totalElement = document.getElementById("total");
totalElement.style.display = "none";

function clearForm() {
  console.log("borrar todo");
  document.getElementById("nombre").value = "";
  document.getElementById("apellido").value = "";
  document.getElementById("tema").value = "";
  totalElement.style.display = "none";
}

function sendData() {
  event.preventDefault();

  const nombre = document.getElementById('nombre').value;
  const apellido = document.getElementById('apellido').value;
  const tema = document.getElementById('tema').value;

  fetch(`endpoint?nombreInput=${nombre}&apellidoInput=${apellido}&temaInput=${tema}`, {
    method: 'POST'
  })
    .then(response => {
      console.log(response);
      return response.json();
    })
    .then(data => renderizarCard([data]))
    .catch(error => console.error('Error:', error));

  // Limpia los campos después de enviar los datos
  clearForm();
}




function renderizarCard(data) {
  const cardContainer = document.getElementById('historial');
  const cards = cardContainer.getElementsByClassName('card');

  // if (cards.length >= 3) {
  //   cardContainer.removeChild(cards[0]); // Elimina la card mas antigua si hay tres o más
  // }

  data.forEach(element => {
    const card = document.createElement('div');
    card.classList.add("card", "text-white", "bg-success", "mb-3", "mr-1");
    card.style.maxWidth = "18rem";

    card.innerHTML =
      `<div class="card-header">Usuario guardado</div>
                <div class="card-body">
      <h5 class="card-title">${element.nombre} ${element.apellido}</h5>
      <p class="card-text">Tema: ${element.tema}</p>
    </div>`;

    cardContainer.appendChild(card);
  });
}











function listarUsuarios() {
			

  fetch('endpoint', {
    method: "GET"
  })
    .then(response => response.json())
    .then(data => renderizarTabla(data))
    .catch(error => console.log("Error al traer los oradores ..." + error))

}













function calculateTotal() {
  console.log("calcular");
  const totalElement = document.getElementById("total");
  const firstName = document.getElementById("firstName").value;
  const lastName = document.getElementById("lastName").value;
  const mail = document.getElementById("mail").value;
  const inputQuantity = document.getElementById("inputQuantity").value;
  const inputCategory = document.getElementById("inputCategory").value;

  let totalToPay = 0;
  const quantity = document.getElementById("inputQuantity").value;

  let subTotal = 200 * quantity;
  const selectElement = document.getElementById("inputCategory").value;

  switch (selectElement) {
    case "student":
      totalToPay = subTotal * 0.2;
      break;
    case "trainee":
      totalToPay = subTotal * 0.5;
      break;
    case "junior":
      totalToPay = subTotal * 0.85;
      break;
    default:
      totalToPay = subTotal;
  }
  totalElement.style.display = "block";
  document.getElementById("total").textContent = "Total a pagar: $" + totalToPay;

  window.alert(
    "Resumen:\nNombre: " +
      firstName +
      "\nApellido: " +
      lastName +
      "\nCorreo Electronico: " +
      mail +
      "\nCantidad: " +
      inputQuantity +
      "\nCategoria: " +
      inputCategory
  );
}

console.log("entra");
