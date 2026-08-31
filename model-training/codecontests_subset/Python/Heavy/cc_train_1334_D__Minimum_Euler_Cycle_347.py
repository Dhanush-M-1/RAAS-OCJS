import sys

def minp():
	return sys.stdin.readline().strip()

def mint():
	return int(minp())

def mints():
	return map(int, minp().split())

def stupid(x, n):
	k = (n-1)*2
	r = 0
	while x >= k:
		x -= k
		r += 1
		k -= 2
	return r

def findl(x, n):
	l, r = 0, n
	while r - l > 1:
		c = (l + r) // 2
		if (2*n - 1 - c)*c <= x:
			l = c
		else:
			r = c
	#if l != stupid(x, n):
	#	print(l, stupid(x, n), x, n);
	#	raise 123
	return l

def solve():
	n, l, r = mints()
	res = []
	f = (r == n*(n-1) + 1)
	r -= l + f - 1
	l -= 1
	x = findl(l, n)
	l -= (2*n-1-x)*x
	k = (n-1-x)*2
	x += 1
	while False:#l >= k:
		print(l, k)
		l -= k
		x += 1
		k -= 2
	y = x + 1 + l // 2
	if l % 2:
		while r >= 2:
			res.append(y)
			if y == n:
				x += 1
				y = x + 1
			else:
				y += 1
			res.append(x)
			r -= 2
		if r != 0:
			res.append(y)
	else:
		while r >= 2:
			res.append(x)
			res.append(y)
			if y == n:
				x += 1
				y = x + 1
			else:
				y += 1
			r -= 2
		if r != 0:
			res.append(x)
	if f:
		res.append(1)
	print(' '.join(map(str,res)))

for i in range(mint()):
	solve()
