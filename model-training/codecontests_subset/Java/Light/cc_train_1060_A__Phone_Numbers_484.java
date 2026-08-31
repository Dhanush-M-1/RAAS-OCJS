(function () {
    var eights = 0;
    var n=parseInt(readline());
    for (var ch of readline())
        if (ch === '8')
            eights++;
    print(Math.min(n / 11>>0, eights))
}());
