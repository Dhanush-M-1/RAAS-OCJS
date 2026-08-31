a,b=map(int,input().split())
ans=a
r=a
while r//b>=1:
    ans=ans+r//b
    r=r//b+r%b
print(ans)
    