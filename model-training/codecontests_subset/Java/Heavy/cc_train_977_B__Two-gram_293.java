// http://codeforces.com/contest/977/problem/B

var arg1 = readline();
var arg2 = readline();

var length = parseInt(arg1);
var string = arg2;

function main(length, string) {
    var hash = {};

    for (var i = 0; i < length - 1; i++) {
        var substring = `${string[i]}${string[i + 1]}`;
        if (hash[substring]) {
            hash[substring] = hash[substring] + 1;
        } else {
            hash[substring] = 1;
        }
    }

    var twogrammaList = Object.keys(hash);
    var biggest = twogrammaList[0];

    for (var j = 1; j < twogrammaList.length; j++) {
        var tg = twogrammaList[j];

        if (hash[tg] > hash[biggest]) {
            biggest = twogrammaList[j];
        }
    }

    return biggest;
}

print(main(length, string));
