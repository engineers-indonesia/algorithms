const readline = require('readline')
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

var numbers = [];
var target = 0;

rl.question('Input arrays: ', (num) => {
    rl.question('Input target: ', (tar) => {
        numbers = num.split(" ").map(Number)
        target = tar;
        search(numbers, target);
        rl.close();
    });
});

const search = (arr, target) => {
    for(i in arr) {
        console.log(`Index ${i} = ${arr[i]}`);
        if (i === target) {
            console.log(`## Found target in index ${arr[i]}`);
            break;
        }
    }
}