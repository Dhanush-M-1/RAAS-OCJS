import sys

n,m=map(int,input().split())
c=set(map(int,sys.stdin))

d=[0]*(n+1)
d[0]=1
d[1]=1 if 1 not in c else 0
for j in range(2,n+1):
    if j in c:
        pass
    else:
        d[j]=(d[j-1]+d[j-2])%1000000007

print(d[n])