n,k=map(int,input().split())
ans=n
ogr=0
while n>=k:
    n,ogr=n//k,n%k
    ans+=n
    n+=ogr 
print(ans)