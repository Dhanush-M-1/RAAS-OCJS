from math import *
n,x,y=input().split()
n,x,y=int(n),int(x),int(y)
z=ceil(n*(y/100))-x
if(z<0):
    print(0)
else:
    print(z)
