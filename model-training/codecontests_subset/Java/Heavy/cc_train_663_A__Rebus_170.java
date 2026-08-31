var rebus = readline().split(' ').map(String);

var count = {plus: 1, minus: 0}; // number of + and - in rebus (add +1 to 'plus' because of the very first '?' is + by default)

for (var i = 0; i < rebus.length; i++) {
	if (rebus[i] == '+') {
		count.plus += 1;
	} else if (rebus[i] == '-') {
		count.minus += 1;
	}
	if (rebus[i] == '=') {
		n = Number(rebus[i + 1]);
	}
}

// used for look_for parameter
var plus = '+'; 
var minus = '-';

// if possible get rebus with this function
var getRebus = function(increase, ones, look_for) {
	var sum = 0;
	if (increase == count.plus) {
		sum = ones + n;
	} else {
		sum = ones - n;
	}
	
	var diff = sum - increase;
	var a = Math.floor(diff / (n - 1)); // a --> change a number of ?'s to n
	var b = diff % (n - 1) + 1; // b --> change another ? to b
	var counter = 0; // used to count how many ?'s are replaced with n (count a)

	// if diff is 0, I want every ? to be 1
	if (diff === 0) {
		rebus[0] = 1;
	// if I want 'n' to appear 0 times, the first ? must be b (ONLY do this when increasing +?'s)
	} else if (a === 0 && increase == count.plus) {
		rebus[0] = b;
	} else {
		// ONLY when increasing +?'s
		if (increase == count.plus) {
			rebus[0] = n;
			counter = 1;
		// ONLY when increasing -?'s
		} else {
			rebus[0] = 1;
		}
		for (var i = 1; i < rebus.length; i++)  {
			// I only want to replace ? with n a times, the next replacement should be b, the rest should be 1
			if (counter == a) {
				if (rebus[i] == look_for) {
					rebus[i + 1] = b;
					break;
				}
			} else {
				if (rebus[i] == look_for) {
					rebus[i + 1] = n;
					counter += 1;
				}
			}
		}
	}

	// replacing all other ?'s with 1's
	for (var i = 1; i < rebus.length; i++) {
		if (rebus[i] == '?') {
			rebus[i] = 1;
		}
	}

	rebus = rebus.join(' ');

	return rebus;
};

// Increase 'minus' ?'s
if (count.plus - count.minus > n) {
	var sum = count.plus - n;
	if (sum >= count.minus && sum <= count.minus * n) {
		print('Possible');
		print(getRebus(count.minus, count.plus, minus));
	} else {
		print('Impossible');
	}
// Increase 'plus' ?'s
} else {
	var sum = count.minus + n;
	if (sum >= count.plus && sum <= count.plus * n) {
		print('Possible');
		print(getRebus(count.plus, count.minus, plus));
	} else {
		print('Impossible');
	}
}
