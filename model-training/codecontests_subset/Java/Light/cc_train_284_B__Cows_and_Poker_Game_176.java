;(function () {

	print((function (n, str) {

		var m = {A: 0, F: 0, I: 0};
		for (var i = 0; i < n; i++) m[str[i]]++;
		return m.I > 1 ? 0 : (m.I === 1 ? 1 : m.A);

	})(+readline(), readline()));

}).call(this);