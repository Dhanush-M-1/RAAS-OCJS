import math
n,x,y=map(int,input().split())
a=math.ceil(n*y/100)
if a>x:
    
    print(abs(x-a))
else:
    print(0)