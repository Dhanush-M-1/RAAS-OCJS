function solve() {
   function plus(a, b, c) {
      return ((a + b) % 1000000007 + c) % 1000000007;
   }
   var T = Number(read());
   var a = [1, 1, 3];
   var b = [0, 1, 1];
   var c = [0, 0, 1];
   var ans = [0, 0, 1];
   for (var i = 3; i < 2000000; i++) {
      a.push(plus(b[i - 1], b[i - 1], a[i - 1]));
      b.push(a[i - 1]);
      c.push(plus(b[i - 1], c[i - 1], 0));
      ans.push(plus(b[i - 1], ans[i - 3], 0));
   }
 
   for (var t = 0; t < T; t++) {
      var n = Number(read());
      write((ans[n - 1] * 4) % 1000000007);
   }
}
 
 
var isNode = typeof console !== 'undefined';
var MEMORY = [];
var MEMORY_INDEX = 0;
if (isNode) {
   var fs = require('fs');
   var path = require('path');
 
   var inTextName;
   var outTextName;
   if (process.argv.length === 5) {
      inTextName = process.argv[3];
      outTextName = process.argv[4];
   }
 
   if (inTextName) {
      fs.readFile(path.join(__dirname, inTextName), 'utf8', (err, data) => {
         MEMORY = data.split('\r\n');
         solve();
      });
   } else {
      var RL = require('readline').createInterface({
         input : process.stdin,
         output : process.stdout
      });
 
      RL.on('line', (line) => {
         MEMORY.push(line);
      });
 
      RL.on('close', solve);
   }
} else {
   solve();
}
 
function write(value) {
   isNode ? console.log(value) : print(value);
}
function read() {
   return isNode ? MEMORY[MEMORY_INDEX++] : readline();
}