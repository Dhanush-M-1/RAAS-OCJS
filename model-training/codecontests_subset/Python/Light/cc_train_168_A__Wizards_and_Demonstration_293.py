import math
n,x,y=map(int,input().split())
l=int(math.ceil(n*y/100))
if(l>x):
    print(l-x)
else:
    print(0)