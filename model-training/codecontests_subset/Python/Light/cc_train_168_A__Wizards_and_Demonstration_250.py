import math
n,x,y=map(int,input().split())
ans=math.ceil((y*n/100))
if x>=ans:
    print(0)
else:
    print(ans-x)