from math import ceil
n,x,y=map(int,input().split())
if (ceil(y*n/100)-x)>0:
	print(ceil(y*n/100)-x)
else:
	print(0)