// console.log("テスト");

// console.error("エラーです");
// console.warn("警告です");

// for(let i= 0;i<3;i++){
//     console.count();
// }

// let obj = {
//     name: "john",
//     age: 35,
//     gender : "male",
//     sayHello : function(){
//         alert("Hello!");
//     }
// };

// console.table(obj);

// function keisan(num){
//     let culc = num*3;

//     if(culc%9===0){
//         culc += 1
//     }
//     return culc;
// }
// let num = 2;
// for(let i = 0;i<10;i++){
//     num = keisan(num);
// }

let button = document.querySelector("button");

button.addEventListener("click",function(){

    let el = document.querySelector("div");
    this.textContent = "clickされました";
});