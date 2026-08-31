;(function () {

	print(function () {

		var c = readline().split(' ').map(Number),
			s = c.reduce(function (p, e) { return p + e; }, 0),
			k = s / 5;

		return k === parseInt(k) && s > 0 ? k : -1;

	}());

}.call(this));
