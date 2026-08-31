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

def cnt(s, sub):
	c = 0
	for i in range(len(s) - len(sub) + 1):
		for j in range(i, i + len(sub)):
			if s[j] != sub[j - i]:
				break
		else:
			c += 1
	return c

def main():
	n, m = vars()
	a = array()
	b = array()

	ans = None 

	ma = Counter(a)
	for i in b:
		if i in ma:
			ans = i 
			break
	if ans != None:
		print('YES')
		print(1, ans)

	else:
		print('NO')
if __name__ == "__main__":
	t = int(input())
	# t = 1
	for _ in range(t):
		main()