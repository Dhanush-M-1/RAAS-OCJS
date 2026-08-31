import math
n,x,y=map(int,input().strip().split()[:3])
if x>=(math.ceil(y*n)/100):
	print(0)
else:
	k=math.ceil((y*n)/100)
	p=k-x
	print(p)
