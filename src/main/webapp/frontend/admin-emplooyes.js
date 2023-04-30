let employees = [];
try{
    employees= JSON.parse(document.getElementById("employees").value);
    console.log(document.getElementById("employees").value);

}catch (e){
    console.log("Arreglo vacío")


}
console.log(employees);

if(employees.length>0){

    let tbody = document.getElementById("table-body");
    let content="";
    for(let emplooye of employees){

        content += `<tr class="tr__item">
                    <td><img src="../images/panadero-profile.png" class="table__image"></td>
                    <td>${emplooye.name}</td>
                    <td>${emplooye.id}</td>
                    <td>${emplooye.email}</td>
                    <td>${emplooye.itemsSold}</td> 
                    <td>
                        <div class="button_container">
                        
                            <form action="/admin-employees" method="post" class="form__button__item" >
                                <button type="submit" name="idDeleteEmployee" value="${emplooye.id}"><img src="images/delete.png"></button>
                            </form>
                        </div>
                    </td>

                </tr>`;
        tbody.innerHTML=content;

    }

}else{
    let table = document.getElementById("table-products");
    table.style.textAlign="center";
    table.innerHTML="<h2>Aún no se han agregado empleados </h2>"
}
let registerError = document.getElementById("registerError").value;
console.log(registerError);
if(registerError!="null"){
    Swal.fire(
        {
            icon: 'warning',
            title: 'Oops...',
            text: registerError
        }
    );
}