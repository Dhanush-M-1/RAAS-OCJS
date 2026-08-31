import math
n,x,y=list(map(int,input().split()))
a=(y/100)*n
a=math.ceil(a)
if x>=a:
    print(0)
else:
    print(int(a-x))    