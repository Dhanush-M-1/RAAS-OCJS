function trim(s) {
	return s.replace(/^\s+|\s+$/gm, '');
}

function tokenize(s) {
	return trim(s).split(/\s+/);
}

function tokenizeIntegers(s) {
	var tokens = tokenize(s);
	for (var i = 0; i < tokens.length; i += 1) {
		tokens[i] = parseInt(tokens[i], 10);
	};
	return tokens;
}

function printValues() {
	var parts = [];
	for (var i = 0; i < arguments.length; i += 2) {
		parts.push(arguments[i]+' = '+arguments[i+1]);
	}
	print(parts.join(', '));
}

function main() {
	var data = tokenizeIntegers(readline()),
		n = data[0], m = data[1],
    weights = tokenizeIntegers(readline()),
    read = tokenizeIntegers(readline()),
    before = [], seen = new Array(n);
  for (var i = 0; i < n; ++i) {
    before[i] = 0;
    seen[i] = false;
  }
  var total = 0;
  for (var i = 0; i < m; ++i) {
    read[i] -= 1;
    var book = read[i];
    //print('read '+(book+1));
    for (var j = before[book]; j < i; ++j) {
      //print('  lift '+(read[j]+1));
      var k = read[j];
      if (!seen[k]) {
        total += weights[k];
        seen[k] = true;
      }
    }
    for (var j = before[book]; j < i; ++j) {
      seen[read[j]] = false;
    }
    before[book] = i+1;
  }
  print(total);
}

main();
