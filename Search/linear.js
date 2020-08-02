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
    let idx = 0;
    arr.forEach(function(val, i) {
        console.log(`Index ${i} = ${val}`);
        console.log(`val = ${val}, target = ${target}`);
        if (val == target) {
            idx = i;
            return;
        }
    });
    console.log(`## Found target in index ${idx}`);
}
