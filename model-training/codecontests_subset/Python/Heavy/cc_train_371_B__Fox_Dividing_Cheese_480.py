import sys
import math
import functools

def sol(a,b):
	if (a,b) in mem:
		return mem[(a,b)]
	if (b,a) in mem:
		return mem[(b,a)]
	if a == b:
		mem[(a,b)] = 0
		return 0
	else:
		min_so_far = float('inf')
		for x in [2,3,5]:
			if a % x == 0:
				min_so_far = min(min_so_far, 1 + sol(a/x,b))
			if b % x == 0:
				min_so_far = min(min_so_far, 1 + sol(a,b/x))
		mem[(a,b)] = min_so_far
		return min_so_far

a,b = list(map(int, sys.stdin.readline().strip().split(' ')))
mem = {}
ans = sol(a,b)
if ans == float('inf'):
	print(-1)
else:
	print(ans)