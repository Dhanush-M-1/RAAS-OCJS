import math, sys
from collections import defaultdict, Counter, deque
 
INF = float('inf')
MOD = (10 ** 9) + 7
 
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
	arr = array()
	if arr[0] + arr[1] <= arr[-1]:
		print(1, 2, n)
	else:
		print(-1)

if __name__ == "__main__":
	t = 1
	t = int(input())
	for _ in range(t):
		main()