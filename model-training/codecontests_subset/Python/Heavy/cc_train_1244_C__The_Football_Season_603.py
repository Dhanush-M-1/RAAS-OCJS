n, p, w, d = map(int, input().split())
xx = -1
if p == 0:
	print(0,0,n)
else:
	for x in range(d):
		if (p - x*w) % d == 0:
			xx = x
			break
	if xx == -1:
		print(-1)
	else:
		def gcd(s,t):
			if s == 0:
				return t
			if t == 0:
				return s
			if s < t:
				s,t = t,s
			return gcd(s%t,t)
		g = gcd(d,w)
		g = d // g
		m = -100000000000000079097709
		dd = 10000000000000000097009
		while abs(m-dd) > 1:
			sr = (m+dd)//2
			if (sr*g+xx)*w < p:
				m = sr
			else:
				dd = sr
		c = (m+dd)//2 - 20
		while ((c+1)*g+xx)*w <= p:
			c += 1
		x = xx + c * g
		y = (p - x * w)//d
		if x + y <=n and x >= 0:
			print(x,y,n-x-y)
		else:
			print(-1)