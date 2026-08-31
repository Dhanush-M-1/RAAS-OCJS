import math
from collections import defaultdict, Counter, deque

INF = float('inf')

def gcd(a, b):
	while b:
		a, b = b, a%b
	return a

def isPrime(n):
	if (n <= 1): 
		return False
	i = 2
	while i ** 2 <= n:
		if n % i == 0:
			return False
		i += 1
	return True

def primeFactor(n):
	if n % 2 == 0:
		return 2
	i = 3
	while (i ** 2) <= n:
		if n % i == 0:
			return i 
		i += 1
	return n

def vars():
	return map(int, input().split())

def array():
	return list(map(int, input().split()))

def main():
	n = int(input())
	arr = array()
	h = arr.count(100)
	t = arr.count(200)
	f = 0 
	s = 0

	while t > 0:
		if f <= s:
			f += 2
		else:
			s += 2
		t -= 1

	while h > 0:
		if f <= s:
			if s - f >= 2 and h > 1:
				f += 1
				h -= 1
			f += 1
		else:
			if f - s >= 2 and h > 1:
				s += 1
				h -= 1
			s += 1

		h -= 1

	if s == f:
		print('YES')
	else:
		print('NO')




if __name__ == "__main__":
	# t = int(input())
	t = 1
	for _ in range(t):
		main()







