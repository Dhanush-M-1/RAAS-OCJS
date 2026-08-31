t=int(input())
while t:
    t-=1
    n=int(input())
    a=[int(x) for x in input().split()]
    res=[]
    mx=0
    mn=0
    for i in range(n):
        if(a[i]==-1):
            if(i-1>=0 and a[i-1]!=-1):
                res+=[max(0,a[i-1])]
            if(i+1<n and a[i+1]!=-1):
                res+=[max(0,a[i+1])]
    #print(res)
    if(len(res)):
        mn=min(res)
        mx=max(res)
    val=(mx+mn)//2
    for i in range(n):
        if(a[i]==-1):
            a[i]=val
    mx=-1
    for i in range(n-1):
        res=abs(a[i]-a[i+1])
        if(res>mx):
            mx=res
    print(mx,val)
