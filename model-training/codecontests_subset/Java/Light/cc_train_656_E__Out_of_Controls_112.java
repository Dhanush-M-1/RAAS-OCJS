function RunReduce(func,e,qarg){
   func(e,qarg);
   return e?RunReduce(func,e-1,qarg):0;
}
var p=parseFloat(readline());
var fr=[];
function Get(e){
	var ssstr;
   fr.push((ssstr=readline()).split(' ').map(parseFloat));
}
Get.name="Get";
RunReduce(Get,p-1);
var ft=fr;
function Cycle_3(e,qarg){
   var i=p-qarg[0]-1;
   var j=p-e-1;
   var k=p-qarg[1]-1;
   ft[i][j]=Math.min(ft[i][j],ft[i][k]+ft[k][j]);
}
function Cycle_2(e,qarg){
   RunReduce(Cycle_3,p-1,[e,qarg]);
}
function Cycle_1(e){
   RunReduce(Cycle_2,p-1,e);
}
RunReduce(Cycle_1,p-1);
print(ft.reduce(function(r,a){return Math.max(r,a.reduce(function(r,a){return Math.max(r,a)},0));},0));