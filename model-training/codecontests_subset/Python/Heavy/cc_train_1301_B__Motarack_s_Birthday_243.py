t=int(input())
def gag(a,k):
    ans=0
    for x in range(len(a)-1):
        a1,b1=a[x],a[x+1]
        if a1==-1:
            a1=k
        if b1==-1:
            b1=k
        m=abs(a1-b1)
        if m>ans:
            ans=m
    return ans
round=lambda x:int(x+0.5)
for x in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    l,r=0,10**9
    while r-l>=0.1:
        m=(l+r)/2
        q,w=gag(a,(l+m)/2),gag(a,(m+r)/2)
        if w>q:
            r=m
        else:
            l=m
    k1=round(l)
    k2=round(r)
    if gag(a,k1)>gag(a,k2):
        print(gag(a,k1),k1)
    else:
        print(gag(a,k2),k2)
    
