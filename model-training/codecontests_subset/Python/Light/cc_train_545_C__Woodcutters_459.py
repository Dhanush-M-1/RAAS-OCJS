# from debug import debug
import sys
input = sys.stdin.readline

n = int(input())
lis = []
for i in range(n):
	x, h = map(int, input().split())
	lis.append((x, h))
if n <= 2: print(n); exit()
else:
	ans = 2
	last = lis[0][0]
	for i in range(1, n-1):
		x, h = lis[i]
		if x > last+h: ans += 1; last = x
		elif lis[i+1][0] > x+h: ans += 1; last = x+h
		else: last = x
	print(ans)
