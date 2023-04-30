let products = [];
let botonEnviar  = document.getElementById("confirm-sale-button");

let productsAddedToSale = [];
try {
    products = JSON.parse(document.getElementById("products").value);


}catch (e){
    console.log(e + " El arreglo es null")
}
const deleteSaleDetail = (id)=>{

    console.log("Deleting sale datail")

    productsAddedToSale = productsAddedToSale.filter(productsAddedToSale=> productsAddedToSale.product.id !=id)
    fillSaleContainer();
    calculateTotal();
}

const fillSaleContainer= ()=>{
    let container = document.getElementById("previsualizacion__container");
    container.innerHTML="";
    let content="";
    for(let product of productsAddedToSale){
        console.log(product.product.price);

        content+=`
                <div class="previsualizacion__item" onclick="deleteSaleDetail(${product.product.id})">
                    <p>${product.product.name} <span>x${product.amount} unidades</span> <span>$${parseFloat(product.product.price*product.amount) }</span> </p>
                </div>
        `;
    }
    container.innerHTML=content;
}
const addProductHandler = (id)=>{
    let cantidad = prompt("Ingrese la cantidad");
    if(isNaN(cantidad)){
        alert("El valor ingresado no es válido.")
        return;
    }
    for (let product of products){
        console.log("Product id ", product.id);
        console.log("id: ", id)
        if(product.id == id){
            console.log(product);
            productsAddedToSale.push({product,amount:cantidad});
        }
    }
    fillSaleContainer();
    calculateTotal();
    console.log(productsAddedToSale);
}
const calculateTotal = ()=>{
    let acum= 0;
    for(let saleDetail of productsAddedToSale ){
        acum+= saleDetail.product.price * saleDetail.amount;
    }
    document.getElementById("total").innerText=acum;
}
let containerProductos = document.getElementById("productos__container");
let content ="";
if(products.length>0){
    for (let product of products){

        content+=`<div class="product__item" onclick="addProductHandler(${product.id})">
                 <img src=${product.urlImage}>
                 <p>${product.name}</p>
              </div>`


    }
    containerProductos.innerHTML=content;

}else{
    containerProductos.innerText= "Sin productos disponibles";
}

botonEnviar.addEventListener("click",(e)=>{
    e.preventDefault();
    if(productsAddedToSale.length>0){
        document.getElementById("data-sale-input").value = JSON.stringify(productsAddedToSale);

        botonEnviar.form.submit();

    }else alert("Debe agregar un producto para generar una compra");


});

