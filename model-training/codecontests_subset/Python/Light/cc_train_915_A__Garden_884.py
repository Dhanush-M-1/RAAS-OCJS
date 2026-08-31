n,k=map(int,input().split())
a=list(map(int,input().split()))
ans=1000000
for i in range(n):
    if k%a[i]!=0:
        pass
    else:
        ans=min(ans,k//a[i])
print(ans)
        
