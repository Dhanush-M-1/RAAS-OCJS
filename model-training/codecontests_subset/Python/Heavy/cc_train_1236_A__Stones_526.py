t=int(input())
for i in range(t):
    a,b,c=map(int,input().split())
    
    c1=c
    a1=a
    b1=b
    ans1=0
    ans=0
    if c>=2 and b>=1:
        mn2=min(2*b,c)
        b=b-(mn2//2)
        c=c-(mn2//2)*2
        ans+=3*(mn2//2)
    if b>=2 and a>=1:
        mn1=min(2*a,b)
        a=a-(mn1//2)
        b=b-(mn1//2)*2
        ans+=3*(mn1//2)
    
    if b1>=2 and a1>=1:
        mn4=min(2*a1,b1)
        a1=a1-(mn4//2)
        b=b-(mn4//2)*2
        ans1+=3*(mn4//2)
    if c1>=2 and b1>=1:
        mn3=min(2*b,c)
        c1=c1-(mn3//2)*2
        b1=b1-(mn3//2)
        ans1+=3*(mn3//2)
        
   
    print(max(ans1,ans))
    