"use strict";

// readline().split(' ').map(value => +value);
var n = +readline();
var A = new Array(Math.pow(10, 5) + 100).fill(0);
for (var i = 0; i < n - 1; ++i) {
    var input = readline().split(' ').map(value => +value);
    var u = input[0];
    var v = input[1];
    
    ++A[u];
    ++A[v];
}

var result = 'YES';
for (var i = 1; i <= n; ++i) {
    if (A[i] === 2) {
        result = 'NO';
        break;
    }
}

write(result);