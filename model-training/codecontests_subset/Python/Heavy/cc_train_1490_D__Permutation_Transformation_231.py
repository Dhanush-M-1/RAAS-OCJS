# Contest: 1417
# Problem: A
import math, sys
from collections import defaultdict, Counter, deque
from bisect import bisect_left, bisect_right

INF = float('inf')
MOD = int(1e9) + 7
MAX = int(1e6) + 1

ans = []

def dc(arr, l, r, depth):
	if r - l < 1:
		return 
	m = arr.index(max(arr[l:r]), l, r)

	ans[m] = depth

	dc(arr, l, m, depth + 1)
	dc(arr, m + 1, r, depth + 1)


def solve():
	n = int(input())
	global ans
	ans = [0 for i in range (n)]

	arr = array()

	dc(arr, 0, n, 0)
	print(*ans)


def main():
	t = 1 
	t = int(input())
	for _ in range(t):
		solve()
















def gcd(a, b):
	while b:
		a, b = b, a%b
	return a

def input():
	return sys.stdin.readline().rstrip('\n').strip()

def print(*args, sep=' ', end='\n'):
	first = True
	for arg in args:
		if not first:
			sys.stdout.write(sep)
		sys.stdout.write(str(arg))
		first = False 

	sys.stdout.write(end)

primes = [ 1 for i in range(MAX) ]
def sieve():
	global primes
	primes[0] = primes[1] = 0 
	i = 2
	while i <= MAX ** 0.5:
		j = i * i
		while primes[i] and j < MAX:
			if j % i == 0:
				primes[j] = 0 
			j += i 
		i += 1

def vars():
	return map(int, input().split())
 
def array():
	return list(map(int, input().split()))

if __name__ == "__main__":
	main()
