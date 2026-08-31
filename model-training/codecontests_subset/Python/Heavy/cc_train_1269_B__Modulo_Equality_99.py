import math 
n,m=map(int,input().split())
a=list(map(int,input().split()))
b=list(map(int,input().split()))

a.sort()
b.sort()
fin=100000000000
for i in range(n):
	ax=a[i:]+a[:i]
	ans=True
	if(b[0]>=ax[0]):
		x=(b[0]-ax[0])%m
	else:
		x=(b[0]+m-ax[0])%m
	for i in range(n):
		if(b[i]>=ax[i]):
			y=(b[i]-ax[i])%m
			if(y==x):
				continue
			else:
				ans=False
				break
		else:
			y=(b[i]+m-ax[i])%m
			if(y==x):
				continue
			else:
				ans=False
				break
	if(ans==True):
		fin=min(fin,x)
print(fin)
