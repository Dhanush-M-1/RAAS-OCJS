var n = parseInt(readline());
var s = "#" + readline() + "#";

var ans = "";
// var prev = s[0];


function isVowel(c) {
    return c == 'a' || c == 'e' || c == 'i' || c =='o' || c == 'u' || c == 'y';
}
var i = 1;
var count = 0;
while(i <= n) {
    //print(s[i])
    if(!isVowel(s[i])) {
        ans += s[i];
    } else {
        count = 1;
        while(s[i] == s[i + 1]) {
            count++;
            i++;
        }
        if((s[i] == 'e' || s[i] == 'o') && count == 2) {
            ans += s[i] + s[i];
        } else {
            ans += s[i];
        }
        
    }
    i++;
}


print(ans);