var n = parseInt(readline());
s = readline().split('');
var i;
for (i = 1; i < n; i++) {
    var lowel = 0;
    if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' || s[i] == 'y'){
        lowel = 1;
    }
    var start = i-1;
    while (i<n && s[i] == s[i-1] && lowel){
        i++;
    }
    if (s[start] == 'e' || s[start] == 'o'){
        if (i - start > 2){
            for(var j=start+1; j<i; j++){
                s[j] = '#';
            }
        }
    }
    else {
        if (i - start > 1){
            for(var j=start+1; j<i; j++){
                s[j] = '#';
            }
        }
    }
    // print(s);
    if (i - start > 1)
        i--;
}
output = ""
for (i = 0; i < n; i++) {
    if (s[i] != '#'){
        output += s[i];
    }
}
print(output);