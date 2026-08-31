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

def vars():
	return map(int, input().split())

def array():
	return list(map(int, input().split()))

def main():
	arr = array()

	if sum(arr) > 0 and sum(arr) % 5 == 0:
		print(sum(arr) // 5)
	else:
		print(-1)

if __name__ == "__main__":
	# t = int(input())
	t = 1
	for _ in range(t):
		main()







