var l = 0;
function main() {
    var x = readline().trim().split(' ').map((x) => parseInt(x));
    var n = parseInt(readline().trim());
    var g = {};
    for (var i = 0; i < n; i++) {
        var a = readline().trim().split(' ').map((x) => parseInt(x))
        for (var j = a[1]; j <= a[2]; j++) {
            g[a[0] + '-' + j] = true;
        }
    }
    var p = [[x[0], x[1]]];
    var d = [x[2], x[3]];
    var c = 0;
    var nbr = [0]
    var visited = {}
    var added = {};
    added[x[0] + '-' + x[1]] = true
    var r = [1, 0, -1, 0, -1, 1, -1, 1]
    var rr = [0, 1, 0, -1, -1, 1, 1, -1]
    while (p.length > c) {
        if (compare(p[c], d)) {
            return nbr[c];
        }
        if (visited[p[c][0] + '-' + p[c][1]]) {
            continue;
        }
        for (var i = 0; i < r.length; i++) {
            var cell = [(p[c][0] + r[i]), (p[c][1] + rr[i])]
            var sc = cell[0] + '-' + cell[1]
            if (g[sc] && !added[sc]) {
                p.push(cell)
                nbr.push(nbr[c] + 1);
                added[sc] = true;
            }
        }

        visited[p[c][0] + '-' + p[c][1]] = true;
        c++;
    }

    return -1;
}

print(main())


function compare(a, b) {
    return a[0] == b[0] && a[1] == b[1]
}