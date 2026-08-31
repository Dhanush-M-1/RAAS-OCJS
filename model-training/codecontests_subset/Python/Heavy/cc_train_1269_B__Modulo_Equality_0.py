import sys
input=sys.stdin.readline
from collections import deque
n,m=map(int,input().split())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
a.sort()
b.sort()
a=deque(a)
b=deque(b)
ans=0
for _ in range(n):
	if a==b:
		break
	f=1
	for j in range(n-1):
		if b[j+1]-a[j+1]!=b[j]-a[j]:
			f=0
			break
	if f:
		if b[0]>a[0]:
			print(ans+b[0]-a[0])
			exit()
		else:
			print(ans+b[0]-a[0]+m)
			exit()
	p=m-a[-1]
	ans+=p
	ww=0
	for j in range(n):
		a[j]+=p
		if a[j]==m:
			ww=n-j
			break
	for j in range(ww):
		a.pop()
		a.appendleft(0)
print(ans)