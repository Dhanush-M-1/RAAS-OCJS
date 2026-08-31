import sys

MOD=10**9+7
N,M=map(int,input().split())
bad=set(map(int,sys.stdin))

a,b=0,1
for i in range(1,N+1):
    if i in bad:
        a,b=b,0
        if a==0:
            break
    else:
        a,b=b,(a+b)%MOD

print(b)
