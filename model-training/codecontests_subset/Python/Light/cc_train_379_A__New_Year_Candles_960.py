a,b=map(int,input().split())
ans=a
while(a>=b):
    c=a//b
    a=a%b+c
    ans+=c
print(ans)