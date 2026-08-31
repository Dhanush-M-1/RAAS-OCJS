x=+readline()
s=readline()
var curs="";
var result = "";
var count = 0;
for(i=0; i<x; i++) {
    if(isVowel(s[i])) {
        if(s[i] == curs) {
            count++;
            curs = "";
            curs += s[i];
        } else {
            result+=curs;
            if(count==2 && (curs=='e' || curs=='o')) result+=curs;
            curs=s[i];
            count = 1;
        }
    } else {
        result+=curs;
        if(count==2 && (curs=='e' || curs=='o')) result+=curs;
        curs="";
        count=0;
        result+=s[i];
    }
}
result+=curs;
if(count==2 && (curs=='e' || curs=='o')) result+=curs;

print(result);

function isVowel(a) {
    if(a=='a'||a=='e'||a=='i'||a=='o'||a=='u'||a=='y') return true;
    return false;
}