let xhr = new XMLHttpRequest();

xhr.open("GET","./data.json");
xhr.responseType = "json";

xhr.onload = function(){
    let div1 = document.getElementById("element1");
    let div2 = document.getElementById("element2");


    div1.textContent = this.response["name"];
    div2.textContent = this.response["age"];
}

xhr.send();