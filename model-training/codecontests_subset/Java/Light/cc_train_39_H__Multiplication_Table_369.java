var radix=parseInt(readline());
for(var i = 1;i < radix; ++i){
  for(var j = 1;j < radix; ++j){
    write((i*j).toString(radix)+" ");
  }
  print();
}