var root = function(dsu, v) {
    if (dsu[v] === v) {
        return v;
    } else {
        dsu[v] = root(dsu, dsu[v]);
        return dsu[v];
    }
}

var main = function () {
    var n = parseInt(readline());
    var p = [], prev = [], next = [];
    readline().split(/\s+/).forEach(function (t, i) {
        p.push(parseFloat(t));
    });

    for (var i = -1; i <= n; ++i) {
        prev[i] = next[i] = i;
    }

    var s = [];
    p.forEach(function(e, i) {
        s.push({pos: i, val: e});
    });

    s.sort(function(a, b) {
        return (a.val !== b.val) ? (a.val - b.val) : (a.pos - b.pos);
    });

    var ans = 0;
    var dec = 0;
    var left = n - 2;
    s.forEach(function (e, i) {
        if (left <= 0) {
            return;
        }
                
        var i = e.pos;
        next[i] = i + 1;
        prev[i] = i - 1;
        var lf = root(prev, i);
        var rg = root(next, i);
        
        var cur = e.val - dec;
        dec = e.val;
        ans += left * cur;
        left--;

        if (0 <= lf && lf <= rg && rg < n) {
            ans += Math.min(p[lf] - dec, p[rg] - dec);
        }

        return left > 0;
    });

    print(ans);
};

main();
