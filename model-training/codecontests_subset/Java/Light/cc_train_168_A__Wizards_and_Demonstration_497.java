;(function () {
	
	var s = readline().split(' ').map(Number);
	var n = s[0], x = s[1], y = s[2];

	var r = Math.ceil(n * (y / 100)) - x;

	print( ( r > 0 ) ? r : 0 );

}).call(this);