var n=+readline();
var s=readline();
var i = 0;
var ans = "";
while (i < n) {
    if (s[i] != 'a' && s[i] != 'e' && s[i] != 'i' && s[i] != 'o' && s[i] != 'u' && s[i] != 'y') {
        ans += s[i];
        ++i;
    } else {
        var j = i;
        while (j < n && s[j] == s[i]) {
            ++j;
        }
        if (j - i == 2 && (s[i] == 'e' || s[i] == 'o')) {
            ans += s[i];
            ans += s[i];
        } else {
            ans += s[i];
        }
        i = j;
    }
}
print(ans);