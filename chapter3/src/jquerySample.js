let p = $('.paragraph');
console.log(p.text());

let box = $(`#box`);
box.text("はじめてのjQuery");

let div = $(`<div></div>`);
console.log(div);
let result = $(`#result`);
div.text("追加されました");
result.append(div);

let input = $(`#input`);
input.on("focus",function(){
    console.log(`フォーカスされました`);
});

let button = $(`button`);
let count = 0;
console.log(button);
button.on("click",function(){
    count++;
    console.log(count+`回クリックされました`);
});

$.ajax({
    type:`get`,
    url: `user.json`

})
.done(function(response){
    console.log(`UserName: `+response[`name`]);
    console.log(`UserAge: `+response[`age`]);

});