
n,m=map(int,input().split())
a=[1]*(n+1)
for i in range(m):
    a[int(input())]=0
p0=a[0]
p1=a[1]
for i in range(2,n+1):
    if a[i]==1:
        p2=p0+p1
    else:
        p2=0
    p0,p1=p1,p2
print(p1%1000000007)
