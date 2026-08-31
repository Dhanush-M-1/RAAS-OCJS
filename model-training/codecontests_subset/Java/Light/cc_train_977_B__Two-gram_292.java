var n = readline(), str = readline().split('');
var cnt = new Map();
var ans = str[0] + str[1], max = 1;
for(var i = 0; i < str.length - 1; i++) {
    var tp = str[i] + str[i + 1];
    if(cnt.has(tp)) {
        cnt.set(tp, cnt.get(tp) + 1);
        if(max < cnt.get(tp)) {
            max = cnt.get(tp);
            ans = tp;
        }
    }
    else {
        cnt.set(tp, 1);
    }
}
print(ans);