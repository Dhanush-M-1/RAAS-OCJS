n,m,*a=map(int,open(0).read().split())
d=[1]*(n+1)
for i in a:
    d[i]=0
for i in range(2,n+1):
    if d[i]!=0:
        d[i]=d[i-1]+d[i-2]
print(d[-1]%(10**9+7))