n,m=map(int,input().split())
ans=n
while int(n):
    ans+=n/m
    n=n/m
print(int(ans))
