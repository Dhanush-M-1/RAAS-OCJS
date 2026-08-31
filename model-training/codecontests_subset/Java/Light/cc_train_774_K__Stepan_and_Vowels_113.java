var n = readline();
var s = readline();
var currO = false;
var currE = false;
for(var i = 0 ; i < s.length; i++){
    if(s[i] != 'o') currO = false;
    if(s[i] != 'e') currE = false;
    if(s[i] == 'a' && i +1 < s.length &&  s[i+1] == 'a') {
        s = s.slice(0,i) + s.slice(i+1,s.length);
        i--;
        continue;
    }
    if(s[i] == 'o' && ((i + 2 < s.length &&  s[i+1] == 'o' && s[i+2] == 'o') || (currO && i+1 < s.length && s[i+1] == 'o') )) {
        s = s.slice(0,i) + s.slice(i+1,s.length);
        i--;
        currO = true;
        continue;
        
    }
    if(s[i] == 'e' && ((i + 2 < s.length &&  s[i+1] == 'e' && s[i+2] == 'e') || (currE && i +1 < s.length && s[i+1] == 'e' ))) {
        s = s.slice(0,i) + s.slice(i+1,s.length);
        i--;
        currE = true;
        continue;
    }
    if(s[i] == 'i' && i+1 < s.length && s[i+1] == 'i') {
        s = s.slice(0,i) + s.slice(i+1,s.length);
        i--;
        continue;
    }
    if(s[i] == 'u' && i+1 < s.length && s[i+1] == 'u') {
        s = s.slice(0,i) + s.slice(i+1,s.length);
        i--;
        continue;
    }
    if(s[i] == 'y' && i+1 < s.length && s[i+1] == 'y') {
        s = s.slice(0,i) + s.slice(i+1,s.length);
        i--;
        continue;
    }
}
print(s);