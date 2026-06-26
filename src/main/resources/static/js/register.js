function registrar() {
    const nombre = document.getElementById("nombre").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    fetch("http://localhost:8080/auth/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nombre: nombre,
            email: email,
            password: password,
            rol: "USER"
        })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("No se pudo registrar el usuario");
            }
            return response.text();
        })
        .then(data => {
            document.getElementById("mensaje").innerHTML =
                `<span class="text-success">${data}</span>`;

            setTimeout(() => {
                window.location.href = "login.html";
            }, 1200);
        })
        .catch(error => {
            document.getElementById("mensaje").innerHTML =
                `<span class="text-danger">${error.message}</span>`;
        });
}