from sys import stdin
stdin.readline
def mp(): return list(map(int, stdin.readline().strip().split()))
def it():return int(stdin.readline().strip())
from math import pi,sqrt
from collections import defaultdict as dd,ChainMap as cc

def pf(n):
	v=[]
	d=dd(lambda:0)
	while n%2==0:
		n//=2
		d[2]+=1

	for j in range(3,int(sqrt(n))+1):
		if n%j==0:
			while n%j==0:
				n//=j
				d[j]+=1
	if n>2:
		d[n]+=1

	return d

n,m=mp()
if n==m:
	print(0)
else:
	a=pf(n)
	b=pf(m)
	c=cc(dict(a),dict(b))
	ans=flag=0

	for i in c:
		if i==2:
			ans+=abs(a[i]-b[i])
		elif i==3:
			ans+=abs(a[i]-b[i])
		elif i==5:
			ans+=abs(a[i]-b[i])
		else:
			if a[i]!=b[i]:
				flag=1
				break

	if flag:
		print(-1)
	else:
		print(ans)



