// let str1 = `Hello,
// World!!`;
// console.log(str1);


// let str2 = `Hello\nWorld!!`;

// let name = `Taro`;
// let a =10;
// let b = 5;
// let str = `${name}is fifteen.
// Fifteen is ${a+b}, not ${2*a+b}.`
// console.log(str);

// let str2 = name + 'is fifteen.\nFifteen is '+ (a+b) +',not' + (2*a+b)+ '.';

// let arr1 =[18,34,42];
// let copy_arr = [...arr1];
// let push_arr = [...arr1,88,99];
// let merge_arr = [...arr1,...copy_arr];
// let max = Math.max(...arr1);

// let customer1 = {
//     name: 'taro',
//     age:35
// };

// let customer2 = {...customer1};

// let customer3 = {...customer1,hobby:`tennis`};

// let detail = {
//     address:`tokyo`,
//     mail:`test@hoge.com`
// };
// let customer1_detail = {...customer1,...detail};

// let new_customer1 = {...customer1,...{name:`jiro`,age:28}};

// function exampleTag(formats,...args){
//     console.log(formats);

//     console.log(args);

//     return `${formats[0]} 「${args[0]}」 ${formats[1]}「${args[1]}」${formats[2]}`;
// } 

// let greeting = `こんにちは`;
// let name = '山田';

// console.log(exampleTag `${greeting}、${name}さん`);

// let arr = [18,34];
// let [hoge, fuga] = arr;
// console.log(hoge);
// console.log(fuga);

// console.log(arr);

// let arr = [18,34,42,7,26];
// let [hoge,fuga,...other] = arr;
// console.log(hoge);
// console.log(fuga);
// console.log(other);

function method(){
    let n1 = 200;
    let n2 = 250;
    return[n1,n2];
}

let[number1,number2]= method();
console.log(number1);
console.log(number2);

let[,number3] = method();
console.log(number3);

let num1 =10;
let num2 = 20;
[num2,num1] = [num1,num2];
console.log(num1);
console.log(num2);