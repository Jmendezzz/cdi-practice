
let status = document.getElementById("status").value;

let error = document.getElementById("error").value;

console.log(typeof(error));

console.log((error==="null"));

if(status==="failed"){
    Swal.fire(
        {
            icon: 'error',
            title: 'Oops...',
            text: 'Credenciales invalidas!'
        }
    );
}

if(!(error==="null") ){
    Swal.fire(
        {
            icon: 'warning',
            title: 'Oops...',
            text: error
        }
    );

}