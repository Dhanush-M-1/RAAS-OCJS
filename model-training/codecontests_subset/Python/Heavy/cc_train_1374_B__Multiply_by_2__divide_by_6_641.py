import math, sys
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

def primeFactors(n):
	factors = []
	i = 2
	while i ** 2 <= n:
		while n % i == 0:
			factors.append(i)
			n //= i 
		i += 1
	if n > 1:
		factors.append(n)
	return factors

def vars():
	return map(int, input().split())

def array():
	return list(map(int, input().split()))

def main():
	n = int(input())
	c3, c2 = 0, 0
	while n % 3 == 0:
		c3 += 1
		n //= 3

	while n % 2 == 0:
		c2 += 1
		n //= 2

	if c2 > c3 or n > 1:
		print(-1)
	else:
		print(c3 + (c3 - c2))


if __name__ == "__main__":
	t = int(input())
	# t = 1
	for _ in range(t):
		main()







