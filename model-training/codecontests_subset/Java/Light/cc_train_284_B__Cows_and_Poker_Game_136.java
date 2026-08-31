var i,
	n = +readline(),
	s = readline(),
	c = {
		'A': 0,
		'F': 0,
		'I': 0
	};

for (var i = 0; i < n; i++)
	c[s[i]]++;

print(c.I>1?0:c.I===1?1:c.A);