t=int(input())
for i in range(t):
    n=int(input())
    a=[int(v) for v in input().split()]
    p=n//2
    c=1
    b=[]
    f=0
    for j in range(1,p):
        if a[j]==a[j-1]:
            c=c+1
        else:
            b.append(c)
            c=1
    b.append(c)
    #print(b)
    if a[p-1]==a[p]:
        del b[-1]
    if len(b)<3:
        f=1
    else:
        p=b[0]
        j=1
        q=0
        while j<len(b) and q<=p:
            q=q+b[j]
            j=j+1
        if q<=p:
            f=1
        else:
            r=0
            while j<len(b):
                r=r+b[j]
                j=j+1
            if r<=p:
                f=1
    if f==1:
        print("0 0 0")
    else:
        print(p,q,r)
            
