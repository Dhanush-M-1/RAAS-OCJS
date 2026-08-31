var x ;
 var Arr , c ,v0 ,v1 ,a ,l ,sum , count ;

nextLine();
function nextLine(){
var x = readline()
if(x){
Arr = x.split(" ").map(function(x) { return parseInt(x); })
c= Arr[0]
v0 = Arr[1]
v1 = Arr[2]
a =Arr[3]
l = Arr[4]
sum = 0 ;
count=0 ; 
sum = 0 ;
count = 0;

summer();
}
}


function summer (){
sum += (v0+count*a<v1)?v0+count*a:v1 ;
if(sum < c ){sum-= l ;count++; summer() }
else {print(count+1) ;nextLine() } 

}

