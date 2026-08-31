for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    
    b=[]
    maa=0
    if(a[0]!=-1)and(a[1]==-1):
        b.append(a[0])
    if(a[-1]!=-1)and(a[-2]==-1):
        b.append(a[-1])
    
    for i in range(1,n-1):
        if(a[i]!=-1)and((a[i-1]==-1)or(a[i+1]==-1)):
            b.append(a[i])
    for i in range(1,n):
        if(a[i-1]!=-1)and(a[i]!=-1):
            maa=max(maa,abs(a[i]-a[i-1]))
    
            
    if(b==[]):
        print(0,0)
        continue
    ma=max(b)
    mi=min(b)
    
    k=(ma+mi)//2
    m=max(abs(ma-k),abs(mi-k))
    
    print(max(m,maa),k)
                
               
