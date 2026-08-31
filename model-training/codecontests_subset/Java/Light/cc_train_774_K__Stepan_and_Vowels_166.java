var L = readline().split(' ').map(function(v){return +v;});
var n = L[0];
var s = readline();

var i = 0;
var l = s.length;
var cnt = 0;
var t = "";
while(i < l) {
    if((i===0||s[i]==s[i-1]) && (s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u'||s[i]=='y')) {
        cnt+=1;
    } else {
        if(i>0 && cnt==2 && (s[i-1]=='e'||s[i-1]=='o')) {
            t+=s[i-1];
            t+=s[i-1];
        } else if(cnt>=1 && (s[i-1]=='a'||s[i-1]=='e'||s[i-1]=='i'||s[i-1]=='o'||s[i-1]=='u'||s[i-1]=='y')) {
            t+=s[i-1];
        }
        if(s[i]=='a'||s[i]=='e'||s[i]=='i'||s[i]=='o'||s[i]=='u'||s[i]=='y') {
            cnt=1;
        } else {
            cnt=0;
            t+=s[i];
        }
    }
    i+=1;
}
if(i>0 && cnt==2 && (s[i-1]=='e'||s[i-1]=='o')) {
    t+=s[i-1];
    t+=s[i-1];
} else if(cnt>=1 && (s[i-1]=='a'||s[i-1]=='e'||s[i-1]=='i'||s[i-1]=='o'||s[i-1]=='u'||s[i-1]=='y')) {
    t+=s[i-1];
}

print(t);