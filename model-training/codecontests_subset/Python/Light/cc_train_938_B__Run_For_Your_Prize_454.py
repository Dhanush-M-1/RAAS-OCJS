import math
n=int(input())
a=list(map(int,input().split()))
minm=10**9
for i in range(0,n-1):
	x=max(a[i]-1,10**6-a[i+1])
	if minm>x:
		minm=x 
		
x=min(a[n-1]-1,10**6-a[0],minm)
print(x)
