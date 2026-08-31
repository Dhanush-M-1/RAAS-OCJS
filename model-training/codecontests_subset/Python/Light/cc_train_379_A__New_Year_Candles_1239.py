a,b=map(int,input().split())
ans=a
p=a
while p//b > 0:
    ans+=p//b
    p=p%b+p//b
print(ans)
