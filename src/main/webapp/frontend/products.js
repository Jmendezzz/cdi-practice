let errors=[];

try {
    errors = JSON.parse(document.getElementById("errors").value);

}catch (e){
    console.log(e +" El arreglo es null")
}



console.log(errors);


for (let error of errors){

    let div = document.getElementById(error);
    let p = document.createElement("p");
    p.innerText="Debe completar los campos";
    p.style.color="red";
    div.appendChild(p);


}
let products = [];
try {
    products = JSON.parse(document.getElementById("products").value);


}catch (e){
    console.log(e + " El arreglo es null")
}


if(products.length>0){
    console.log(products.length);

    let tbody = document.getElementById("table-body");
    let content="";

    for(let product of products){
        console.log(product.name);

        content += `<tr class="tr__item">
                    <td><img src="${product.urlImage}" class="table__image"></td>
                    <td>${product.name}</td>
                    <td>${product.avaibleAmount}</td>
                    <td>${product.status ? "Disponible" : "No Disponible"}</td>
                    <td>${product.price}</td> 
                    <td>
                        <div class="button_container">
                            <form action="/products" method="post" class="form__button__item" >
                                <button type="submit" name="idDelete" value="${product.id}"><img src="images/delete.png"></button>
                            </form>                                                                                                                           
                        </div>
                    </td>

                </tr>`;

    }
    tbody.innerHTML = content;

}else{
    let table = document.getElementById("table-products");
    table.style.textAlign="center";
    table.innerHTML="<h2>Aún no se han agregado productos </h2>"

}


