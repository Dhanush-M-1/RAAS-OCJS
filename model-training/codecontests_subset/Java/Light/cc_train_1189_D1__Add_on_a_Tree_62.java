var n = +readline();
var arr = [];
for (var i = 0; i < n; i++) {
  arr[i] = 0;
}
for (var i = 1; i < n; i++) {
  var point = readline().split(' ').map(item => +item - 1);
  arr[point[0]]++;
  arr[point[1]]++;
}
print(arr.find(item => item === 2) ? 'NO' : 'YES');
