n,k=map(int,input().split())
a=list(map(int,input().split()))
ans=2147483647
for i in range(0,n):
    if k%a[i]==0:
        ans=min(k//a[i],ans)
print(ans)