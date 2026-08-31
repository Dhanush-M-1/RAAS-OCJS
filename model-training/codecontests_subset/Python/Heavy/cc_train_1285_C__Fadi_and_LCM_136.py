def prime_factorize(n):
	factors = []
	orig_n = n
	d = 2
	while d*d <= orig_n and n > 1:
		if n%d==0:
			pk = 1
			while n%d==0:
				n //= d
				pk *= d
			factors.append(pk)
		d += 1
	if n > 1:
		factors.append(n)
	return factors
factors = prime_factorize(int(input()))
ansA, ansB = 10**18, 10**18 #INF
for mask in range(1<<len(factors)):
	a, b = 1, 1
	for i in range(len(factors)):
		if mask&(1<<i):
			a *= factors[i]
		else:
			b *= factors[i]
	if max(a,b) < max(ansA,ansB):
		ansA, ansB = a, b
print(ansA,ansB) 
