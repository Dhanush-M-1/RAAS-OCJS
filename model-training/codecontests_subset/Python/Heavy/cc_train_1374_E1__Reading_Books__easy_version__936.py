# n=int(input())
# n,k=map(int,input().split())
# arr=list(map(int,input().split()))
#ls=list(map(int,input().split()))
#for i in range(m):
# for _ in range(int(input())):
from collections import Counter
#from fractions import Fraction
#n=int(input())
#arr=list(map(int,input().split()))
#ls = [list(map(int, input().split())) for i in range(n)]
from math import log2
#for _ in range(int(input())):
#n, m = map(int, input().split())
# for _ in range(int(input())):

n, m = map(int, input().split())
a = []
b = []
c = []
for i in range(n):
	t, u, v = map(int, input().split())
	if u == 0 and v == 0:
		continue
	else:
		if u == 1 and v == 1:
			c.append(t)
		elif u == 1:
			a.append(t)
		else:
			b.append(t)

a.sort()
b.sort()
for i in range(min(len(a),len(b))):
	c.append(a[i]+b[i])
if len(c)<m:
	print(-1)
else:
	print(sum(sorted(c)[:m]))