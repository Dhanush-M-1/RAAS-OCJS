from math import ceil
n,x,y=map(int,input().split())
ans=max(0,ceil(y*n/100.0-x))
print(ans)