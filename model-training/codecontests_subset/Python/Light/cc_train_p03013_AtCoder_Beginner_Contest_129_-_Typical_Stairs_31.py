n,m=map(int,input().split())
a=[1]*(n+1)
for _ in range(m):a[int(input())]=0
p,q=0,1
for i in range(1,n+1):
    p,q=q,a[i]*(p+q)%(10**9+7)
print(q)