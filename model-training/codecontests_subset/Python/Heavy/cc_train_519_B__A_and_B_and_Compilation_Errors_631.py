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

def can(m, s):
	if 0 <= s <= m * 9:
		return True
	return False

def main():
	n = int(input())

	arr1 = array()
	arr2 = array()
	arr3 = array()

	m1 = Counter(arr1)
	m2 = Counter(arr2)
	m3 = Counter(arr3)

	err1, err2 = None, None

	for k in m1:
		if k not in m2:
			err1 = k
			break
		if m2[k] < m1[k]:
			err1 = k
			break

	for k in m2:
		if k not in m3:
			err2 = k
			break
		if m3[k] < m2[k]:
			err2 = k
			break

	print(err1)
	print(err2)
	




if __name__ == "__main__":
	# t = int(input())
	t = 1
	for _ in range(t):
		main()







