import math, sys
from collections import defaultdict, Counter, deque
 
INF = float('inf')
MOD = 10 ** 9 + 7
 
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
	factors = defaultdict(int)
	i = 2
	while i ** 2 <= n:
		while n % i == 0:
			factors[i] += 1
			n //= i 
		i += 1
	if n > 1:
		factors[n] += 1 
	return factors
 
def vars():
	return map(int, input().split())
 
def array():
	return list(map(int, input().split()))


def main():
	n, m = vars()
	s = input()
	arr = array()

	arr.sort()

	j = 0

	ans = [0 for i in range(26)]

	for i in range(n):
		while j < m and i == arr[j]:
			j += 1

		if j >= m:
			break
		
		if i < arr[j]:
			ans[ord(s[i]) % 97] += (m - j)

	for i in range(n):
		ans[ord(s[i]) % 97] += 1 

	print(*ans)


if __name__ == "__main__":
	t = 1
	t = int(input())
	for _ in range(t):
		main()
