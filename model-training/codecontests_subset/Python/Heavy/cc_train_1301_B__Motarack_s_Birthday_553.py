t=int(input())
for i in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    mi=10000000000
    ma=-1
    md=-1
    for i in range(len(a)-1):
        ai,ai1=a[i],a[i+1]
        
        if ai==-1:
            if ai1!=-1:
                mi=min(ai1,mi)
                ma=max(ai1,ma)
            
                
        elif ai1==-1:
            mi=min(ai,mi)
            ma=max(ai,ma)
        else:
            md=max(md,abs(ai-ai1))
    if ma==-1:
        print(0,1)
    else:
        mia=(mi+ma)//2
        
        print(max(ma-mia,mia-mi,md),mia)
