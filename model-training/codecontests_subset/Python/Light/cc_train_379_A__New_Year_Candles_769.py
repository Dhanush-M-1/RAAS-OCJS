a,b=map(int,input().split())
ans=0
c=0
while a!=0:
    ans+=a
    c+=a
    a=c//b
    c%=b
print(ans)
