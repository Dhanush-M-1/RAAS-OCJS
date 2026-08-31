import math
n,x,y=list(map(int,input().split()))


a=math.ceil(n*y/100)

if a>x:
    print(a-x)
else:
    print(0)
