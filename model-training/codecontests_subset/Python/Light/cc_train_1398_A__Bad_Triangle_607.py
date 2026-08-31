import sys
from math import ceil, factorial, gcd
#from math import comb, perm 	only in python3
from collections import Counter, deque, defaultdict
from bisect import bisect_left, bisect_right 
from heapq import heappop, heappush, heapify
MOD = 10**9 + 7
INF = float('inf')

rl = lambda : list(map(int, sys.stdin.readline().split()))
rs = lambda : sys.stdin.readline().strip()

for _ in range(int(input())):
	n = int(input())
	A = rl()
	print(1, 2, n) if A[0] + A[1] <= A[-1] else print(-1)