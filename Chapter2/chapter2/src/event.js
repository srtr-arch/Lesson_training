let button = document.querySelector("button");
let count = 0;
button.addEventListener("click",function(){
count++;
let message = document.getElementById("message");
message.textContent = count+"回クリックされました";
});

let listChild = document.getElementById("list").children;

for(let i=0;i<listChild.length;i++){
listChild[i].addEventListener("mouseover",function(){
    this.style.color = "lightgreen";
});
listChild[i].addEventListener("mouseout",function(){
    this.style.color = "white";
});

}
let key = document.getElementById("key");
document.addEventListener("keydown",function(e){
    if(e.key=="y"){
        let keyEL=document.createElement("p");
        keyEL.textContent="「y」キーが入力されました。";
        key.appendChild(keyEL);
    }

});

let input = document.getElementsByTagName("input");
console.log(input[0]);
input[0].addEventListener("focus",function(){
    this.style["background-color"]="purple";
});
input[0].addEventListener("blur",function(){
    this.style["background-color"]="white";
});

// let select = document.getElementsByTagName("select").children;
// console.log(select);
// for(let i=0;i<select.length;i++){
//     select[i].addEventListener("change",function(){
//         document.getElementsById("text").textContent= select[i].value;
//     });
// }

// let select = document.getElementById("select");
// select.addEventListener("change",function(e){
//  document.getElementById("text").textContent= e.target.value;
// });

let select = document.getElementsByTagName("select")[0];

    // イベントリスナーを追加
    select.addEventListener("change", function() {
        // 選ばれたオプションの値を取得して、#text のテキストを更新
        document.getElementById("text").textContent = select.value;
    });

let button1 = document.getElementById("addBtn");
button1.addEventListener("click",function(){
let newP = document.createElement("p");
newP.textContent = "追加されました";
newP.addEventListener("mouseover",function(){
    newP.textContent="カーソルが重なりました";
});
let result = document.getElementById("result");
result.appendChild(newP);

});

