from math import ceil
n,x,y=map(int,input().split())
z=ceil(y*n/100)
if z>x:
	print(z-x)
else:
	print(0)