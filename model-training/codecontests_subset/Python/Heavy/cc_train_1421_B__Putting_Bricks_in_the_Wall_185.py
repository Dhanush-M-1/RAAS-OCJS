import sys
from math import ceil, factorial, gcd
#from math import comb, perm 	only in python3
from collections import Counter, deque, defaultdict
from bisect import bisect_left, bisect_right 
from heapq import heappop, heappush, heapify
MOD = 10**9 + 7
INF = float('inf')

rl = lambda : list(map(int, sys.stdin.readline().split()))

for _ in range(int(input())):
	n = int(input())
	g = [sys.stdin.readline() for _ in range(n)]
	ans = []
	num = 0
	l = [g[0][1], g[1][0], g[n-2][n-1], g[n-1][n-2]]
	if len(set(l)) == 1:
		num += 2
		ans.append([1, 2])
		ans.append([2, 1])
	elif l[0] == l[1]:
		if l[1] == l[2]:
			num += 1
			ans.append([n-1, n])
		if l[1] == l[3]:
			num += 1
			ans.append([n, n-1])
	elif l[0] != l[1] and l[1] == l[2] == l[3]:
		num += 1
		ans.append([2, 1])
	elif l[0] != l[1] and l[0] == l[2] == l[3]:
		num += 1
		ans.append([1, 2])
	elif l[0] != l[1] and l[0] == l[2]:
		num += 2
		ans.append([1,2])
		ans.append([n, n-1])
	elif l[0] != l[1] and l[0] == l[3]:
		num += 2
		ans.append([1, 2])
		ans.append([n-1, n])
	print(num)
	if num:
		for a in ans:
			print(*a)
