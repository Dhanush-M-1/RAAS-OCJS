for _ in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    d={}
    for i in range(1,n-1):
        if a[i]>-1 and (a[i+1]==-1 or a[i-1]==-1):
            d[a[i]]=1
    if a[0]>-1 and a[1]==-1:
        d[a[0]]=1
    if a[-1]>-1 and a[-2]==-1:
        d[a[-1]]=1
    diff=-1    
    for i in range(1,n):
        if a[i]>-1 and a[i-1]>-1:
            diff=max(diff,abs(a[i]-a[i-1]))
    
    
    def check(k,d):
        mi=-10**12
        ma=10**12
        for i in d:
            mi=max(mi,i-k,0)
            ma=min(ma,i+k)
        if mi<=ma:
            return (1,mi)
        else:
            return (0,0)
    
    if len(d)==0:
        print(0,5)
    else:
        low=diff
        high=10**12
        while low<high:
            mid=(low+high)//2
            p=check(mid,d)
            if p[0]:
                ind=p[1]
                high=mid
            else:
                low=mid+1
        p=check(low,d)
        # print(d)
        print(low,p[1])        
        
        
        