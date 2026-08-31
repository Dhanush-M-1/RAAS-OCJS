import math
n,x,y=map(int,input().split())
k=(y/100)*n
k=math.ceil(k)
if k<=x:
 print(0)
else:
 print(abs(k-x))