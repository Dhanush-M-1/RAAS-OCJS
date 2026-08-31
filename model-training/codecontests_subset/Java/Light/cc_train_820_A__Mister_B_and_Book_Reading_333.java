function ansa(c,v0,v1,a,l){

  var points = v0;
  var days = 1;
  var i = 1;

  if(c <= v0){
    print("1");
    return;
  }

  else{
    while(points < c){
      if((v0 + ( i * a) < v1)){
        points+= (v0 + ( i * a)) - l;
      }
      else{
        points += v1 - l;
      }
      days++;
      i++;
    }
  }
  print(days);
}

var line = readline().split(' ');
for(var i = 0 ; i < line.length ; i++) line[i] = parseInt(line[i]);

ansa(line[0],line[1],line[2],line[3],line[4]);
