import sys
input = lambda :sys.stdin.readline().rstrip()
from heapq import heapify,heappop,heappush
n,k = map(int,input().split())
a,b,c=[],[],[]
for _ in range(n):
	t,e,d=map(int,input().split())
	if e and d:
		a.append(t)
	elif e:
		b.append(t)
	elif d:
		c.append(t)
fl=False
if len(b)+len(a)>=k and len(c)+len(a)>=k:
	fl=True
if not fl:
	print(-1)
	sys.exit(0)
heapify(a)
b.sort()
c.sort()
ans=0
for i in range(min(len(b),len(c))):
    heappush(a,b[i]+c[i])
while k:
    ans+=heappop(a)
    k-=1
print(ans)