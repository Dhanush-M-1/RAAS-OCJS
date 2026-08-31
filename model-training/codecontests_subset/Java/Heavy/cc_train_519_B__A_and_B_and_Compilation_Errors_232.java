var n = parseInt(readline().trim())
var a = readline().trim().split(' ').map((x)=>parseInt(x))
var b = readline().trim().split(' ').map((x)=>parseInt(x))
var c = readline().trim().split(' ').map((x)=>parseInt(x))

var _a={}, _b={}, _c={}
for(var i=0;i<n;i++){
    if(_a[a[i]]==undefined)
        _a[a[i]]=0
    _a[a[i]]++
}
for(var i=0;i<n-1;i++){
    if(_b[b[i]]==undefined)
        _b[b[i]]=0
    _b[b[i]]++
}
for(var i=0;i<n-2;i++){
    if(_c[c[i]]==undefined)
        _c[c[i]]=0
    _c[c[i]]++
}

//print(JSON.stringify(_a),JSON.stringify(_b),JSON.stringify(_c))
for(var i in _a){
   // print(i,_b[i],_a[i])
    if(_b[i]!=_a[i]){
        print(i);
        break;
    }
}


for(var i in _b){
    if(_b[i]!=_c[i]){
        print(i);
        break;
    }
}
