  var tmp = readline().split(' ').map(x => parseInt(x));

  var l = tmp[0];
  var r = tmp[1];

  if(r - l >= 1) {
    print(2);
  } else {
    print(l);
  }
  