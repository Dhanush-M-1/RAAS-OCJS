from math import *
n,x,y=map(int,input().split())
xx=(x*100)/n
yy=y-xx
z=(yy*n)/100
if(z<=0):
    print(0)
else:
    print(ceil(z))
