const token = localStorage.getItem("token");

if (!token) {
    window.location.href = "login.html";
}

function cargarProductos() {
    fetch("http://localhost:8080/productos", {
        method: "GET",
        headers: {
            "Authorization": "Bearer " + token
        }
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("No se pudieron cargar los productos");
            }
            return response.json();
        })
        .then(data => {
            const contenedor = document.getElementById("productos");
            contenedor.innerHTML = "";

            data.forEach(producto => {
                const categoria = producto.categoria ? producto.categoria.nombre : "Sin categoría";

                contenedor.innerHTML += `
                <div class="col-md-4">
                    <div class="card h-100 shadow-sm">
                        <div class="card-body">
                            <h5 class="card-title">${producto.nombre}</h5>
                            <p class="card-text">${producto.descripcion}</p>
                            <p><strong>Categoría:</strong> ${categoria}</p>
                            <p><strong>Precio:</strong> S/ ${producto.precio}</p>
                            <p><strong>Stock:</strong> ${producto.stock}</p>
                            <button class="btn btn-primary w-100" onclick="agregarCarrito(${producto.id})">
                                Agregar al carrito
                            </button>
                        </div>
                    </div>
                </div>
            `;
            });
        })
        .catch(error => {
            alert(error.message);
        });
}

function agregarCarrito(productoId) {
    const usuarioId = localStorage.getItem("usuarioId");

    fetch("http://localhost:8080/carrito", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Authorization": "Bearer " + token
        },
        body: JSON.stringify({
            cantidad: 1,
            usuarioId: Number(usuarioId),
            productoId: productoId
        })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("No se pudo agregar al carrito");
            }
            return response.json();
        })
        .then(data => {
            alert("Producto agregado al carrito");
        })
        .catch(error => {
            alert(error.message);
        });
}

function cerrarSesion() {
    localStorage.removeItem("token");
    window.location.href = "login.html";
}

cargarProductos();