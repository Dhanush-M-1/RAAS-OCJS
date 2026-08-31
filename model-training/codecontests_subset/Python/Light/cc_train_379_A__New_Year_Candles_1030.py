a,b=map(int,input().split())
ans=0
ans+=a
c,d=0,0
while a>=b:
    c=a//b
    ans+=c
    a=c+(a%b)    
    
print(ans)