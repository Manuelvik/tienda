const token = localStorage.getItem("token");
const usuarioId = localStorage.getItem("usuarioId");

if (!token) {
    window.location.href = "login.html";
}

function cargarCarrito() {
    fetch(`http://localhost:8080/carrito/usuario/${usuarioId}`, {
        method: "GET",
        headers: {
            "Authorization": "Bearer " + token
        }
    })
        .then(response => response.json())
        .then(data => {
            const tabla = document.getElementById("tablaCarrito");
            const totalTexto = document.getElementById("total");

            tabla.innerHTML = "";
            let total = 0;

            data.forEach(item => {
                const producto = item.producto;
                const subtotal = producto.precio * item.cantidad;
                total += subtotal;

                tabla.innerHTML += `
                <tr>
                    <td>${producto.nombre}</td>
                    <td>S/ ${producto.precio}</td>
                    <td>${item.cantidad}</td>
                    <td>S/ ${subtotal.toFixed(2)}</td>
                    <td>
                        <button class="btn btn-danger btn-sm" onclick="eliminarItem(${item.id})">
                            Eliminar
                        </button>
                    </td>
                </tr>
            `;
            });

            totalTexto.textContent = total.toFixed(2);
        });
}

function eliminarItem(id) {
    fetch(`http://localhost:8080/carrito/${id}`, {
        method: "DELETE",
        headers: {
            "Authorization": "Bearer " + token
        }
    })
        .then(() => {
            cargarCarrito();
        });
}

function generarPedido() {
    const total = Number(document.getElementById("total").textContent);

    if (total <= 0) {
        alert("El carrito está vacío");
        return;
    }

    fetch("http://localhost:8080/pedidos", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + token
        },
        body: JSON.stringify({
            total: total,
            usuarioId: Number(usuarioId)
        })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("No se pudo generar el pedido");
            }
            return response.json();
        })
        .then(data => {
            alert("Pedido generado correctamente");
            window.location.href = "productos.html";
        })
        .catch(error => {
            alert(error.message);
        });
}

function cerrarSesion() {
    localStorage.clear();
    window.location.href = "login.html";
}

cargarCarrito();