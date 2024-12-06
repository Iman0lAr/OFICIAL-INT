let contra1 = document.getElementById("password");
let contra2 = document.getElementById("password2");
let vali_contra = document.getElementsByClassName("val_contra");
let vali_dni = document.getElementById("vali_dni");
let dni = document.getElementById("dni");
let vali_contra1 = document.getElementById("vali_contra1");
let vali_contra2 = document.getElementById("vali_contra2");
let nombre = document.getElementById("nombre");
let vali_per = document.getElementById("vali_per");
let correo = document.getElementById("correo");
let sexo = document.getElementById("sexo");
let tip_us = document.getElementById("tip_us");
let vali_sex = document.getElementById("vali_sex");
let vali_Tipo_us = document.getElementById("vali_Tipo_us");
const contraUpdate1 = document.getElementById("contraUpdate1");
const contraUpdate2 = document.getElementById("contraUpdate2");
const validacion_contraUpdate = document.getElementsByClassName("validacion_contraUpdate");
const val_ContraUpdate = document.getElementsByClassName("val_ContraUpdate");
const val_ContraUpdate2 = document.getElementsByClassName("val_ContraUpdate2");
const userName = document.getElementById("username_buscar");

dni.addEventListener("keypress", (event) => {
    const input = event.target;


    if (event.key < '0' || event.key > '9') {
        event.preventDefault();
    }


    if (input.value.length >= 8) {
        event.preventDefault();
    }
})

function validar() {
    let confirmacion = true;
    if (contra1.value !== contra2.value) {
        confirmacion = false;
        for (let a = 0; a < vali_contra.length; a++) {
            vali_contra[a].style.display = 'block';
        }
    }

    if (contra1.value.length === 0) {
        confirmacion = false;
        vali_contra1.style.display = 'block';
    } else {
        vali_contra1.style.display = 'none';
    }

    if (contra2.value.length === 0) {
        confirmacion = false;
        vali_contra2.style.display = 'block';
    } else {
        vali_contra2.style.display = 'none';
    }

    if (dni.value.length === 0) {
        confirmacion = false;
        vali_dni.style.display = 'block';
    } else {
        vali_dni.style.display = 'none';
    }


    if (nombre.value.length === 0) {
        confirmacion = false;
        vali_per.style.display = 'block';
    } else {
        vali_per.style.display = 'none';
    }


    if (sexo.value.length === 0) {
        confirmacion = false;
        vali_sex.style.display = 'block';
    } else {
        vali_sex.style.display = 'none';
    }

    if (tip_us.value.length === 0) {
        confirmacion = false;
        vali_Tipo_us.style.display = 'block';
    } else {
        vali_Tipo_us.style.display = 'none';
    }

    return confirmacion;
}

function valdiar2() {
    let confirm = true;
    if (contraUpdate1.value !== contraUpdate2.value) {
        confirm = false;
        for (let a = 0; a < validacion_contraUpdate.length; a++) {
            validacion_contraUpdate[a].style.display = 'block';
        }
    }

    if (contraUpdate1.value.length === 0) {
        confirm = false;
        val_ContraUpdate.style.display = 'block';
    } else {
        val_ContraUpdate.style.display = 'none';
    }

    if (contraUpdate2.value.length === 0) {
        confirmacion = false;
        val_ContraUpdate2.style.display = 'block';
    } else {
        val_ContraUpdate2.style.display = 'none';
    }

}

function consumir() {
    const dni = document.getElementById("dni").value;
    fetch(`/api/dni?numero=${dni}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Error en la solicitud: ${response.statusText}`);
                }
                return response.json();
            })
            .then(data => {
                console.log(data);
                document.getElementById("apellido_pat").value = data.apellidoPaterno;
                document.getElementById("nombre").value = data.nombres;
                document.getElementById("apellido_mat").value = data.apellidoMaterno;
                correo.value = data.nombres.split(" ")[0].toLowerCase() + '_' + data.apellidoPaterno.toLowerCase().substring(0, 2) + '_' + dni.substring(6, 9) + '_' + data.apellidoMaterno.toLowerCase().substring(0, 2);
            })
            .catch(error => {
                console.error("Error en la solicitud:", error);
            });
}

const checkbox = document.getElementById('conf');
document.addEventListener('DOMContentLoaded', (event) => {
    verificarCheckbox();
});

function verificarCheckbox() {
    const miModal = new bootstrap.Modal(document.getElementsByClassName("modal")[0]);
    //const modal=document.getElementById('staticBackdrop');
    if (checkbox.checked) {
        miModal.show();
    }
}
const botonCierre = document.getElementById("boton_cierre");
botonCierre.addEventListener("click", () => {
    if (checkbox.checked) {
        checkbox.checked = false;
    }
});

function buscar(boton) {
    let input = boton.nextElementSibling;

    fetch(`/usuario/${input.value}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Error en la solicitud: ${response.statusText}`);
                }
                return response.json();
            })
            .then(data => {
                console.log(data);


            })
            .catch(error => {
                console.error("Error en la solicitud:", error);
            });
}





