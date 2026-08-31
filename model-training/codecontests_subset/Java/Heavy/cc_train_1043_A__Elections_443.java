function calculateProb(str1, str2) {
    var num = parseInt(str1);
    var arr = str2.split(" ").map(function(x) { return parseInt(x); });

    Array.prototype.max = function() {
        return Math.max.apply(null, this);
    };
    var max = Math.max.apply(null, arr);


    var sum = arr.reduce(function(a, b) {
        return a + b;
    }, 0);

    var flg = true;
    var k = max;

    while(flg) {
        var rez = 0;

        for (var i = 0; i < arr.length; i++) {
            rez += (k - arr[i]);
        }

        if (rez > sum) {
            flg = false;
        } else {
            k++;
        }
    }

    return k;
}

var s1 = readline();
var s2 = readline();

print(calculateProb(s1, s2));
