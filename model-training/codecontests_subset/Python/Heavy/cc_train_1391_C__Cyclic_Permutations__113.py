import math, sys
from collections import defaultdict, Counter, deque
 
INF = float('inf')
MOD = 1000000007
 
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
	ans = 1
	power = 1
	for i in range(1, n):
		ans = (ans * i) % MOD
		power = (power * 2) % MOD


	ans = (ans * n) % MOD

	ans = (ans - power) % MOD

	print(ans)

if __name__ == "__main__":
	# t = int(input())
	t = 1
	for _ in range(t):
		main()