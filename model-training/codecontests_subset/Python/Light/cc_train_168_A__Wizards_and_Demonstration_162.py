import math
#for _ in range(int(input())):
n,x,y=map(int,input().split())
d=math.ceil(n*(y/100))
if(d>x):
    print(d-x)
else:
    print(0)