import math
n,x,y=map(int,input().split())
ans=math.ceil(n*y/100)-x
if ans<0:
    ans=0
print(ans)