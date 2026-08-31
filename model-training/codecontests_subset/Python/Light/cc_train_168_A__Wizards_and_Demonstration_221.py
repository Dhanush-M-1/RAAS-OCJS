import math
n,x,y=map(int,input().split())
per=(y/100)*n
t=math.ceil(per)
t-=x
if t<0:
    print("0")
else:
    print(t)
