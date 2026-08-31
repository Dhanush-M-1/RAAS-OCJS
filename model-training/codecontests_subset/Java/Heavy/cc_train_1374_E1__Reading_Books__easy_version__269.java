function sortFunc(x, y) {
   return x - y;
}

function solve() {
   var nk = read().split(' ').map(Number);
   var n = nk[0];
   var k = nk[1];
   var tboth = [];
   var ta = [];
   var tb = [];
   var ca = 0;
   var cb = 0;
   
   for (var i = 0; i < n; i++) {
      var tab = read().split(' ').map(Number);
      var cCase = tab[2] * 2 + tab[1];
      if (cCase === 1) {
         ca++;
         ta.push(tab[0]);
      }
      if (cCase === 2) {
         cb++;
         tb.push(tab[0]);
      }
      if (cCase === 3) {
         ca++;
         cb++;
         tboth.push(tab[0]);
      } 
   }
   ta.sort(sortFunc);
   tb.sort(sortFunc);
   tboth.sort(sortFunc);
   if (ca < k || cb < k) {
      write(-1);
      return;
   }
   var ans = 0;
   var ia = 0;
   var na = ta.length;
   var ib = 0;
   var nb = tb.length;
   var iboth = 0;
   var nboth = tboth.length;
   for (var i = 0; i < k; i++) {
      if (ia >= na || ib >= nb) {
         ans += tboth[iboth++];
         continue;
      }
      if (iboth >= nboth) {
         ans += ta[ia++] + tb[ib++];
         continue;
      }
      if (ta[ia] + tb[ib] < tboth[iboth]) {
         ans += ta[ia++] + tb[ib++];
      } else {
         ans += tboth[iboth++];
      }
   }
   write(ans);
}

function init() {
   var T;
   T = 1;
   //T = Number(read());
   for (var t = 0; t < T; t++) {
      solve();
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
         init();
      });
   } else {
      var RL = require('readline').createInterface({
         input : process.stdin,
         output : process.stdout
      });
    
      RL.on('line', (line) => {
         MEMORY.push(line);
      });
    
      RL.on('close', init);
   }
} else {
   init();
}
 
function write(value) {
   isNode ? console.log(value) : print(value);
}
function read() {
   return isNode ? MEMORY[MEMORY_INDEX++] : readline();
}
