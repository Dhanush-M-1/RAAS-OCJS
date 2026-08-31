import math
n,m=map(int,input().split())
c=0
c+=n
d=0
while(n>=m):
    c+=math.floor(n/m)
    d=n
    n=int(n/m)
    n=n+d%m
print(c)    