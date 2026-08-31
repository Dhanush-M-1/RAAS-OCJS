a,b=map(int,input().split())

ans=a
left=0

while(a>0):
    
    while(a>0):
        ans+=a//b
        left+=a%b
        a=a//b
    if(left<b):
        a=0
    else:
        
        a=left
        left=0

print(ans)
