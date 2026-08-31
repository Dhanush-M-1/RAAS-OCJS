import math
n,x,y=map(int,input().split())
if (y*n)//100 -x>=0:
    print( math.ceil((y*n)/100) -x)
else:print(0)