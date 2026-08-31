var n_ = readline();
var s = readline();
var r = "";

var prev = "~";
var cnt = 0;

for (var i = 0; i < s.length; i = i + 1) {
    if (s[i] == prev) {
        cnt = cnt + 1;
    } else {
        if ((prev == "a") || (prev == "i") || (prev == "u") || (prev == "y")) {
            if (cnt > 1) {
                cnt = 1;
            }
        } else if ((prev == "e") || (prev == "o")) {
            if ((cnt > 1) && (cnt != 2)) {
                cnt = 1;
            }
        }
        for (var j = 0; j < cnt; j = j + 1) {
            r += prev;
        }
        cnt = 1;
    }
    prev = s[i];
}

if ((prev == "a") || (prev == "i") || (prev == "u") || (prev == "y")) {
    if (cnt > 1) {
        cnt = 1;
    }
} else if ((prev == "e") || (prev == "o")) {
    if ((cnt > 1) && (cnt != 2)) {
        cnt = 1;
    }
}
for (var j = 0; j < cnt; j = j + 1) {
    r += prev;
}

print(r);

