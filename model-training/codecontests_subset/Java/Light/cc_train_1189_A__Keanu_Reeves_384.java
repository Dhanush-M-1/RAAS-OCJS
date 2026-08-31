var n=Number(readline());
var s=readline();
var c=0;
for (var i=0; i<n; i++) {
    c+=2*Number(s[i])-1;
}
if (c!=0) {
    print(1);
    print(s);
}
else {
    print(2);
    //print(s[0]+" "+s.slice(1,));
    print(s[0]+" "+s.slice(1, n));
}