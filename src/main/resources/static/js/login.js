function login() {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    fetch("http://localhost:8080/auth/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            email: email,
            password: password
        })
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("Credenciales incorrectas");
            }
            return response.json();
        })
        .then(data => {
            localStorage.setItem("token", data.token);
            localStorage.setItem("usuarioId", data.usuarioId);
            localStorage.setItem("rol", data.rol);

            window.location.href = "productos.html";
        })
        .catch(error => {
            document.getElementById("mensaje").innerHTML =
                `<span class="text-danger">${error.message}</span>`;
        });
}