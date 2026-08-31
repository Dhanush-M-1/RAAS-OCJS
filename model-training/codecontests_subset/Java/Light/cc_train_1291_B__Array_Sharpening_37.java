function main() {
  var testCasesNum = +readline();
  for (var i = 0; i < testCasesNum; i++) {
    var len = +readline();
    var arr = readline()
      .split(" ")
      .map(Number);

    var left = findLeft(arr);
    var right = findRight(arr);
    if (left >= right) {
      print("Yes");
    } else {
      print("No");
    }
  }
}

function findLeft(arr) {
  var left = arr.length;
  for (var j = 0; j < arr.length; j++) {
    if (arr[j] < j) {
      left = j - 1;
      break;
    }
  }
  return left;
}

function findRight(arr) {
  var right = 0;
  for (var k = 0; k < arr.length; k++) {
    if (arr[arr.length - 1 - k] < k) {
      right = arr.length - k;
      break;
    }
  }
  return right;
}

main()