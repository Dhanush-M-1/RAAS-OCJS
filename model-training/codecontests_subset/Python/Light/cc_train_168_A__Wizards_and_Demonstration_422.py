import math
n,x,y=map(int,input().split())
k=math.ceil(y*n/100)
if k>x:
     print(k-x)
else:
     print(0)
