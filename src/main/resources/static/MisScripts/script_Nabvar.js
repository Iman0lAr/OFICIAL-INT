document.getElementById('menu-btn').addEventListener('click', function () {
    var sidebar = document.getElementById('sidebar');

    var menuIcon = document.getElementById('menu-icon');

    // Alternar clase active en el sidebar
    sidebar.classList.toggle('active');

    // Cambiar el ícono del menú hamburguesa a una "X" cuando esté activo y viceversa
    if (sidebar.classList.contains('active')) {
        menuIcon.innerHTML = '&#10005;'; // Ícono de "X" para cerrar
    } else {
        menuIcon.innerHTML = '&#9776;'; // Ícono de hamburguesa para abrir
    }
});

document.addEventListener("DOMContentLoaded", function () {
    const registroSolicitudBtn = document.getElementById("registro-solicitud-btn");
    const subMenu = document.getElementById("sub-menu");

    registroSolicitudBtn.addEventListener("click", function (event) {
        event.preventDefault();
        subMenu.classList.toggle("hidden");
    });
});