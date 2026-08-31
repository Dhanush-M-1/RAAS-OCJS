import fractions
import functools
import itertools
import math
import operator
import random

def try_composite(a, d, n, s):
	if pow(a, d, n) == 1:
		return False
	for i in range(s):
		if pow(a, 2**i * d, n) == n-1:
			return False
	return True
 
def is_prime(n, precision_for_huge_n = 16):
	if n in known_primes:
		return True
	if any((n % p) == 0 for p in known_primes) or n in (0, 1):
		return False
	d, s = n - 1, 0
	while not d % 2:
		d, s = d >> 1, s + 1
	if n < 1373653: 
		return not any(try_composite(a, d, n, s) for a in (2, 3))
	if n < 25326001: 
		return not any(try_composite(a, d, n, s) for a in (2, 3, 5))
	if n < 118670087467: 
		if n == 3215031751: 
			return False
		return not any(try_composite(a, d, n, s) for a in (2, 3, 5, 7))
	if n < 2152302898747: 
		return not any(try_composite(a, d, n, s) for a in (2, 3, 5, 7, 11))
	if n < 3474749660383: 
		return not any(try_composite(a, d, n, s) for a in (2, 3, 5, 7, 11, 13))
	if n < 341550071728321: 
		return not any(try_composite(a, d, n, s) for a in (2, 3, 5, 7, 11, 13, 17))
	return not any(try_composite(a, d, n, s)
	    for a in known_primes[:precision_for_huge_n])
 
known_primes = [2, 3]
known_primes += [x for x in range(5, 1000, 2) if is_prime(x)]

def brent(n):
	if n % 2 == 0:
		return 2
	y, c, m = (
	    random.randint(1, n - 1),
	    random.randint(1, n - 1),
	    random.randint(1, n - 1)
	)
	g, r, q = 1, 1, 1
	while g == 1:
		x = y
		for i in range(r):
			y = ((y * y) % n + c) % n
		k = 0
		while k < r and g == 1:
			ys = y
			for i in range(min(m, r - k)):
				y = ((y * y) % n + c) % n
				q = q * (abs(x - y)) % n
			g = fractions.gcd(q, n)
			k = k + m
		r = r * 2
	if g == n:
		while True:
			ys = ((ys * ys) % n + c) % n
			g = fractions.gcd(abs(x - ys), n)
			if g > 1:
				break
	return g

def factorint(n):
	if n == 1:
		return {1:1}
	f = {}
	s = [n]
	while s:
		n = s[-1]
		d = brent(n)
		if d == 1 or d == n:
			if is_prime(n):
				s.pop()
				f[n] = f.get(n, 0) + 1
		else:
			s.pop()
			s.append(n // d)
			s.append(d)
	return f

X = int(input())
Xf = factorint(X)
divisor = lambda s: functools.reduce(
    operator.mul,
    (list(Xf.keys())[i] ** list(Xf.values())[i] for i in s),
    1
)
subsets = lambda: itertools.chain.from_iterable(
    itertools.combinations(range(len(Xf)), ni) for ni in range(len(Xf) + 1)
)
b = min(d for d in (divisor(s) for s in subsets()) if d >= X ** 0.5)
print("%d %d" % (X // b, b))
