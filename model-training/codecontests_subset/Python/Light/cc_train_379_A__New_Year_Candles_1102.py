a,b=map(int,input().split())
ans=a
rem=0
if b==0:
    print(a)
    exit(0)
while a//b:
    rem=a%b
    ans+=a//b
    a=(a//b) + rem
print(ans)