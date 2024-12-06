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
const botonCierre=document.getElementById("boton_cierre");
botonCierre.addEventListener("click",()=>{
    if(checkbox.checked){
        checkbox.checked=false;
    }
});


function mostrarImagen(event, imgId, containerId) {
    const file = event.target.files[0]; 
    const reader = new FileReader(); 

    reader.onload = function (e) {
        const img = document.getElementById(imgId);
        img.src = e.target.result; 
        img.style.display = 'block'; 

        const container = document.getElementById(containerId);
        container.style.display = 'block'; 
    };

    if (file) {
        reader.readAsDataURL(file); 
    }
}




function consumir1() {
    const dni = document.getElementById("dni_disc").value;
    fetch(`/api/dni?numero=${dni}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Error en la solicitud: ${response.statusText}`);
                }
                return response.json();
            })
            .then(data => {
                console.log(data);
                document.getElementById("dis_ape_paterno").value = data.apellidoPaterno;
                document.getElementById("nom_disc").value = data.nombres;
                document.getElementById("dis_ape_materno").value = data.apellidoMaterno;
            })
            .catch(error => {
                console.error("Error en la solicitud:", error);
            });

}

function consumir2() {
    const dni = document.getElementById("dni_repre").value;
    fetch(`/api/dni?numero=${dni}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Error en la solicitud: ${response.statusText}`);
                }
                return response.json();
            })
            .then(data => {
                console.log(data);
                document.getElementById("repre_apll_pat").value = data.apellidoPaterno;
                document.getElementById("repre_nom").value = data.nombres;
                document.getElementById("repre_apll_mat").value = data.apellidoMaterno;
            })
            .catch(error => {
                console.error("Error en la solicitud:", error);
            });

}



function toggleRepresentante() {
    const representante = document.getElementById('representante').value;
    const representanteInfo = document.querySelectorAll('.representante-info');
    const inputs = document.querySelectorAll('.form-repre .agrupador-cuadros input');
    
    if (representante === 'SI') {
        representanteInfo.forEach(div => {
        div.style.display = 'block'; 
        });
    } else {
        representanteInfo.forEach(div => {
        div.style.display = 'none';
        });
    
        // Limpiar los valores de los inputs
        inputs.forEach(input => {
        input.value = "";
        });
    }
}

function validarFormulario() {
    let verificacion = true;

    let dni_discapacitado = document.getElementById("dni_disc");
    let valid_dni_disc = document.getElementById("valid_dni_disc");

    let copia_dni_disc = document.getElementById("imagen1");
    let valid_copia_disc = document.getElementById("valid_copia_disc");

    let tel_contacto = document.getElementById("tel_contacto");
    let valid_tel_cont = document.getElementById("valid_tel_cont");

    let correo_contacto = document.getElementById("correo_contacto");
    let valid_correo_cont = document.getElementById("valid_correo_cont");

    let num_certi = document.getElementById("num_certi");
    let valid_num_cer = document.getElementById("valid_num_cer");

    let feche_e = document.getElementById("feche_e");
    let valid_Fecha_E = document.getElementById("valid_Fecha_E");

    let imagen3 = document.getElementById("imagen3");
    let valid_cer1 = document.getElementById("valid_cer1");

    let imagen4 = document.getElementById("imagen4");
    let valid_cer2 = document.getElementById("valid_cer2");

    let imagen5 = document.getElementById("imagen5");
    let valid_img_solicitud = document.getElementById("valid_img_solicitud");

    // Validar si el campo de DNI está vacío
    if (dni_discapacitado.value.length === 0) {
        verificacion = false;
        valid_dni_disc.style.display = 'inline';
    } else {
        valid_dni_disc.style.display = 'none';
    }

    // Validar si el campo de teléfono está vacío
    if (tel_contacto.value.length === 0) {
        verificacion = false;
        valid_tel_cont.style.display = 'inline';
    } else {
        valid_tel_cont.style.display = 'none';
    }

    // Validar si el campo de correo está vacío
    if (correo_contacto.value.length === 0) {
        verificacion = false;
        valid_correo_cont.style.display = 'inline';
    } else {
        valid_correo_cont.style.display = 'none';
    }

    // Validar si el campo de número de certificado está vacío
    if (num_certi.value.length === 0) {
        verificacion = false;
        valid_num_cer.style.display = 'inline';
    } else {
        valid_num_cer.style.display = 'none';
    }

    // Validar si el campo de fecha está vacío
    if (feche_e.value === "") {
        verificacion = false;
        valid_Fecha_E.style.display = 'inline';
    } else {
        valid_Fecha_E.style.display = 'none';
    }

    // Validar si se ha seleccionado un archivo en el campo de la copia de DNI
    if (copia_dni_disc.files.length === 0) {
        verificacion = false;
        valid_copia_disc.style.display = 'block';
    } else {
        valid_copia_disc.style.display = 'none';
    }

    // Validar si se ha seleccionado un archivo en los campos de imagenes
    if (imagen3.files.length === 0) {
        verificacion = false;
        valid_cer1.style.display = 'block';
    } else {
        valid_cer1.style.display = 'none';
    }

    if (imagen4.files.length === 0) {
        verificacion = false;
        valid_cer2.style.display = 'block';
    } else {
        valid_cer2.style.display = 'none';
    }

    if (imagen5.files.length === 0) {
        verificacion = false;
        valid_img_solicitud.style.display = 'block';
    } else {
        valid_img_solicitud.style.display = 'none';
    }

    return verificacion;  // Ahora se retorna `verificacion` para que se ejecute correctamente
}


  




