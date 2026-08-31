const nm = readline().split(" ").map(e => parseInt(e));
const n = nm[0];
const m = nm[1];

const p = readline().split(" ").map(e => parseInt(e));
const my = p[n - 1];

const add = (x, y) => {
    if (g[x] === undefined) {
        g[x] = [];
    }
    g[x].push(y);
};
const g = [];
for (var i = 0; i < m; i++) {
    var xy = readline().split(" ").map(e => parseInt(e));
    var x = xy[0];
    var y = xy[1];
    add(y, x);
}

const left = [];
for (var i = 1; i <= n; i++) {
    left[i] = n;
}
if (g[my] !== undefined) {
    for (var i of g[my]) {
        left[i] = n - 1;
    }
}

var result = 0;
var last = n - 1;
for (var i = n - 2; i >= 0; i--) {
    if (left[p[i]] == last) {
        result++;
    } else {
        if (g[p[i]] !== undefined) {
            for (var j of g[p[i]]) {
                if (left[j] == last) {
                    left[j] = i;
                }
            }
        }
        last = i;
    }
}
print(result);