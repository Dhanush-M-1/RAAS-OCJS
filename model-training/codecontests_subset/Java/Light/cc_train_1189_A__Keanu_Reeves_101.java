var n = parseInt(readline());
var str = readline();
var s = str, c = 1;

if (n % 2 === 0) {
  var strArr = str.split('');
  var count = strArr.reduce((prev, curr) => prev + parseInt(curr), 0);
  
  if (n / 2 === count) {
    var last = strArr.pop();
    c = 2;
    s = `${ strArr.join('') } ${ last }`;
  }
}

print(c);
print(s);
