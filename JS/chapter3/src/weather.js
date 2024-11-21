function getWeatherReport(city){

    const url="https://api.openweathermap.org/data/2.5/weather";

    const appId = "";

    const imgUrl = "https://openweathermap.org/img/wn/";

    $.ajax({
        url:url,
        data:{
            appid:"725db08bc57e023dd6c720442ae4fe50",
            q:city,
            lang:"ja"
        }
    })
    .done(function(response){

        $(`#city`).text(response.name);
        $(`#weatherIcon`).attr("src",imgUrl + response.weather[0].icon + `@2x.png`);
        $(`#description`).text(response.weather[0].description);
    })
    .fail(function(XMLHttpRequest,textStatus,errorThrown){
        alert(`エラー`);
        console.log(`XMLHttpRequest : `+XMLHttpRequest.status);
        console.log("textStatus     : "+textStatus);
        console.log("errorThrown    : "+errorThrown.message);
    })
}

getWeatherReport($(`#cities`).val());
$(`#search`).click(function(){
    getWeatherReport($(`#cities`).val());
})

let val1 = 0;
let val2 = val1;
val2 = 1;

console.log(val1+"!!!!!!!!!!!!!!!");

// let array = [5];
// function sample(){
//     sample = 100;
// }
// let a =sample();
// console.log(a);
const obj={
    "id" :1,
    "name" :"sample"
}
console.log(obj.name+"1");
const p1 = "name";
console.log(obj.p1+"2");
console.log(obj[p1]+"3");
console.log(obj["name"]+"4");

let we = `晴れ`
let ms = `今日の天気は${we}です`;
console.log(ms);
console.log(!"");
console.log(!0);
console.log(!NaN);
console.log(!null);
console.log(!undefined);
let a=0;
if(a=1){
    console.log("11");
}else{
    console.log("22");
}

// const log = function(){
//     console.log("test");
// };
// setInterval(log,1000);
e();
function e(){
    let c = 1;
    console.log(c);
    d();
    function d(){
        console.log(`d is called`);

    }
    console.log(`a is called`);
}
const b=0;
console.log(b);
const btn = document.getElementById("btn");
btn.addEventListener("click",piyo);
btn.addEventListener("click",function(){
    console.log("hoge");
});
btn.addEventListener("click",function(){
    console.log("fuga");
});
function piyo(){
    console.log("piyo");
}
