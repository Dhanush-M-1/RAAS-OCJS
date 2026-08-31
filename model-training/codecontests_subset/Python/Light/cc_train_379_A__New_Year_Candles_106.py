#ashu@gate22
n,m=map(int,input().split())
ans=n
a=(n//m)
ans+=a
rem=n%m+a
while rem>=m:
    a1=rem//m
    ans+=a1
    rem=rem%m+a1
print(ans)