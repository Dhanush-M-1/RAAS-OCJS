var line = readline().split(' ');
var n = parseInt(line[0]);
var k = parseInt(line[1]);
var arr = readline().split(' ');
var list = [];

if (n === arr.length) {

for (var i = 0; i < arr.length; i++) {
  
  if (k % arr[i] === 0) {
    list.push(arr[i]);
  }
  
}

print(k / Math.max.apply(Math, list));

}