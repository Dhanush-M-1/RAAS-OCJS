var nk = readline().trim().split(' ').map((_x)=>parseInt(_x));
var n=nk[0],k=nk[1];
var t = readline().trim().split(' ').map((_x)=>parseInt(_x));

var m=0;
k--;
while(true){
    if(k>=(m*(m+1)/2) && k<((m+1)*(m+2)/2)){
        break;
    }
    m++;
}
var i = k-m*(m+1)/2

print(t[i]);