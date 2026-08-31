function input() {
  var n = parseInt(readline().trim());
  return Array(n)
    .fill(0)
    .map(function() {
      return readline()
        .trim()
        .split(" ")
        .map(function(i) {
          return parseInt(i);
        });
    });
}

function solve(a, b, n) {
  if (n % 3 === 0) return a;
  if (n % 3 === 1) return b;
  return a ^ b;
}

function main() {
  // get input
  var read = input();

  for (var i = 0; i < read.length; i++) {
    print(solve(read[i][0], read[i][1], read[i][2]));
  }
}

main();
