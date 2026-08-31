n,k=map(int,input().split())
ans=n
ogr=0
while n+ogr>=k:
    n,ogr=(n+ogr)//k,(n+ogr)%k
    ans+=n
print(ans)