import math
n,x,y=map(int,input().split())
k=math.ceil((y*n)/100)-x
if k>=0:print(k)
else:print(0)