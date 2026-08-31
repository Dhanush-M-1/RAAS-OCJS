function tes(nk, n){
    var t = nk.split(' ');
    var s = n.split(' ').sort(function(a, b) { 
    return a - b;
    });
    for (var i = s.length - 1; i >= 0 ; i--) {
        if (t[1] % s[i] === 0) {
            hMin = t[1]/s[i];
            break;
        }
    }
    print(hMin);
}
tes(readline(), readline());