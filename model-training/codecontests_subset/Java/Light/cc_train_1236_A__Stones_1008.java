var queries = parseInt(readline());


function main(query) {
  var sum = 0;

  if (query[2] > (query[1].length * 2) - 1) {
      return write((3*query[1]) + '\n');
  } else {
    var add = Math.min(Math.floor(query[2]/2), query[1]);
    sum += add*3;
    query[1] -= add;
    if (query[1] > (query[0] * 2) - 1) {
      return write((3*query[0] + sum) + '\n');
    } else {
      return write (sum + (3 * Math.min(Math.floor(query[1]/2), query[0])) + '\n')
    }
  }
}

// main([1, 4, 2])

for (var i = 0; i < queries; i++) {
  var query = readline().split(' ').map(function(num) {
    return parseInt(num);
  })
  main(query)
}
