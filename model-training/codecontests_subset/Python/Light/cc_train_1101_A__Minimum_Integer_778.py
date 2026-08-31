# n,m=map(int,input().split(" "))

t=int(input())

from math import *
for _ in range(t):
	l,r,k=map(int,input().split(" "))
	ans=0
	a=int(floor(l/k))
	if(l%k==0):
		a-=1
	ans=a*k
	if(ans==0):
		a=int(ceil(r/k))
		if(r%k==0):
			a+=1
		print(a*k)
	else:
		print(k)