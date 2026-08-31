a,b=[int(x) for x in input().split()]
ans=a
while a//b>0:
    ans+=a//b
    k=a%b
    a//=b
    a+=k
print(ans)
    
