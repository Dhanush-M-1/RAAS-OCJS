import math
n = int(input())
for _ in range(n):
	a,b,c = input().split()
	c = int(c)
	x = int(a)/c 
	y = int(b)/c 
	x = math.ceil(x-1) 
	y = math.floor(y+1) 
	if(x*c <= 0):
		print(y*c) 
	else:
		if(x>=1):
			print(1*c)




