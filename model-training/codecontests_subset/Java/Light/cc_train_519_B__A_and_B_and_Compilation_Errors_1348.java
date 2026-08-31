var n = parseInt(readline().trim())
var a = readline().trim().split(' ').map((x)=>parseInt(x))
var b = readline().trim().split(' ').map((x)=>parseInt(x))
var c = readline().trim().split(' ').map((x)=>parseInt(x))

var _sort=(_a,_b)=>_a-_b;
a.sort(_sort)
b.sort(_sort)
c.sort(_sort)

var _b=-1;
for(var i=0;i<n-1;i++){
    if(a[i]!=b[i]){
        _b=a[i];
        break;
    }
}
if(_b==-1)
    _b=a[n-1];
    
var _c=-1;
for(var i=0;i<n-2;i++){
    if(c[i]!=b[i]){
        _c=b[i];
        break;
    }
}
if(_c==-1)
    _c=b[n-2];
    
print(_b);
print(_c);