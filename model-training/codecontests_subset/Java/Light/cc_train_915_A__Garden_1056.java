var data = readline().split(' ');
var buckets = readline().split(' ');
function main(){
    var bucketCount  = data[0],
        size = data[1],
        bucketArr = buckets,
        time = 0;
    bucketArr = bucketArr.sort((a,b)=>{return b-a});
    var min = data[data.length-1];
    var len = parseInt(size/bucketArr[bucketArr.length-1]);
    bucketArr.forEach((el)=>{
        var i = 0;
        for(i; i<=len;i++){
          if(size-el*i === 0){
             if(i < min){
                min = i;
            }
          }
        }
      });
      print(min);
}   

main();