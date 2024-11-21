result = document.getElementById("result");
console.log(result);

let paragraph = document.getElementsByTagName("p");
console.log(paragraph);

let h1text = document.getElementsByTagName("h1")[0];
console.log(h1text);
h1text.textContent="h1が変更されました！！";
// document.getElementsByTagName("h1")[0].textContent = "h1が変更されました！！";
// let mainDiv = document.getElementsByClassName("main")[0];
// console.log(mainDiv);
// mainDiv.style.width = "300px";
// mainDiv.style["background-color"]= "lightgreen";
// mainDiv.style["text-align"] = "center";

// for(let i =0; i < paragraph.length; i++){
//     paragraph[i].style.color = "gray";
//     paragraph[i].style["font-size"] = "24px";
//     paragraph[i].style.padding = "10px";
// }
let styleChild = document.createElement("p");
styleChild.textContent = "resultに追加しました。";
result.appendChild(styleChild);


let th1 = document.createElement("th");
let th2 = document.createElement("th");
th1.textContent="名前";
th2.textContent="出身地";

let td1 = document.createElement("td");
let td2 = document.createElement("td");
let td3 = document.createElement("td");
let td4 = document.createElement("td");
let td5 = document.createElement("td");
let td6 = document.createElement("td");
td1.textContent = "タロウ";
td2.textContent = "東京";
td3.textContent = "ハナコ";
td4.textContent = "千葉";
td5.textContent = "サトシ";
td6.textContent = "神奈川";
let tr1 = document.createElement("tr");
let tr2 = document.createElement("tr");
let tr3 = document.createElement("tr");
let tr4 = document.createElement("tr");

let tableChild = document.createElement("table");
let theadChild = document.createElement("thead");
let tbodyChild = document.createElement("tbody");

tr1.appendChild(th1);
tr1.appendChild(th2);
theadChild.appendChild(tr1);
tr2.appendChild(td1);
tr2.appendChild(td2);
tr3.appendChild(td3);
tr3.appendChild(td4);
tr4.appendChild(td5);
tr4.appendChild(td6);
tbodyChild.appendChild(tr2);
tbodyChild.appendChild(tr3);
tbodyChild.appendChild(tr4);





tableChild.appendChild(theadChild);
tableChild.appendChild(tbodyChild);
result.appendChild(tableChild);

let remove = document.getElementById("remove");
remove.remove();