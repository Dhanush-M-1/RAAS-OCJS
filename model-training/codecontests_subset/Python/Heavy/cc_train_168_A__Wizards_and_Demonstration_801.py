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
	n, x, y = vars()
	p = math.ceil(n * (y / 100))
	print(max(0, p - x))


	

if __name__ == "__main__":
	# t = int(input())
	t = 1
	for _ in range(t):
		main()







