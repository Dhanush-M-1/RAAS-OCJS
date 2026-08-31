import math

n,x,y = map(int,input().split())
a = int(math.ceil((y/100)*n)) - x
if a < 0 :
	a = 0
print(a)