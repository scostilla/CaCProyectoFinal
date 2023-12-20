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
