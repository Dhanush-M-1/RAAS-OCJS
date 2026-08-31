import math
n,x,y=map(int,input().split())
y=math.ceil((y/100)*n)
if y<x:
    print(0)
else:
    print(y-x)