n,m=map(int,input().split(" "))
ans=0;i=n
while(i>=m):
    localans=i//m
    i=localans+(i%m)
    ans+=localans
print(ans+n)
