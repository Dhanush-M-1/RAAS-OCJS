import sys
N,M=map(int,input().split())
S=set(map(int,sys.stdin))

a,b=0,1
for i in range(1,N+1):
    if i in S:
        a,b=b,0
    else:
        a,b=b,a+b

print(b%(10**9+7))
