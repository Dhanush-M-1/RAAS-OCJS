# from debug import debug
import sys, bisect
from math import log2 as log
mod = int(1e9)+7
inf = int(1e10)
input = sys.stdin.readline

n, k = map(int, input().split())
lis = sorted(map(int, input().split()))
last = int(2e5)+1
answer = inf
for i in range(1, last):
	x, y = bisect.bisect_left(lis, i), bisect.bisect_right(lis, i)
	f = y-x
	ans = 0
	for j in range(y, n): 
		tt = lis[j]
		c = 0
		while tt != 1:
			if tt == i: break
			tt = tt//2
			c+=1
		if tt == i: f += 1; ans += c
		if f>=k: break
	if f>=k:
		answer = min(answer, ans)
print(answer)
