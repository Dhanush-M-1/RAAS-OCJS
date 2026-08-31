import math
n,k=map(int,input().split())
a=list(map(int,input().split()))
mx=100000000000
for i in a:
    if k%i==0:
        mx=min(mx,k//i)
print(mx)