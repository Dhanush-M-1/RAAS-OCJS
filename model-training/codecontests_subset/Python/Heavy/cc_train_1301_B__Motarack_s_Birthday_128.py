import sys
from math import*
input=sys.stdin.buffer.readline

t=int(input())
while t:
	t-=1
	n=int(input())
	arr=list(map(int,input().split()))
	s,count,dif=[0]*3
	for i in range(n-1):
		if arr[i]==-1 or arr[i+1]==-1:
			continue
		else:
			if dif<int(fabs(arr[i+1]-arr[i])):
				dif=int(fabs(arr[i+1]-arr[i]))
	c=1
	narr=[]
	for i in  range(n):
		if arr[i]==-1:
			c=0
		else:
			if c==0:
				narr.append(arr[i])
				c=1
			else:
				if i+1!=n and arr[i+1]==-1:
					narr.append(arr[i])
				else:
					continue
	#print(narr)
	if len(narr)==0:
		print("0 0")
	else:
		mini=min(narr)
		maxm=max(narr)
		c=(mini+maxm)//2
		print(max(dif,maxm-c,c-mini),c)