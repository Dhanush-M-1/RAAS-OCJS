def res():
    n=int(input())
    a=[]
    b=[]
    
    for i in range(n):
        l,m=map(int,input().split())
        a.append(l)
        b.append(m)
    ans=2
    h=a[0]
    for i in range(1,n-1):
        if(h<(a[i]-b[i])):
            ans=ans+1
            h=a[i]
        elif((a[i]+b[i])<a[i+1]):
            ans=ans+1
            h=a[i]+b[i]
        else:
            h=a[i]
    if n==1:
        print(1)
    else:
        print(ans)
res()