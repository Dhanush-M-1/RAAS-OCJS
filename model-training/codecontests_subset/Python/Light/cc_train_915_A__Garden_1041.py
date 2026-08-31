n,k=map(int,input().split())
l=list(map(int,input().split()))
ans=100000000000
for i in range(n):
    if k%l[i]==0:
        ans=min(ans,k//l[i])
print(ans)