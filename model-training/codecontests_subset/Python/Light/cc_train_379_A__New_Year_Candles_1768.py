a,b=map(int,input().split())
ans=0
while True:
    ct=(a//b)*b
    ans+=ct
    extra=(a//b)
    a=a-ct+extra
    if extra==0:
        ans+=a
        break
print(ans)