var s=readline().split(" ");
var n=parseInt(s[0]),k=parseInt(s[1]);
var ar=readline().split(" ");
for(var i=0;i<n;i++){ar[i]=parseInt(ar[i]);}
var res=100;
for(var i=0;i<n;i++){
if(k%ar[i]===0&&k/ar[i]<res){res=k/ar[i];}

}print(res);