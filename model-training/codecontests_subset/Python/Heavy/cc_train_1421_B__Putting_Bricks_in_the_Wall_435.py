t=int(input())
for i in range(t):
    n=int(input())
    a=[]
    an=[]
    for j in range(n):
        a.append(input().strip())
    p,q=int(a[0][1]),int(a[1][0])
    r,s=int(a[-1][-2]),int(a[-2][-1])
    if r==s:
        pt=r^1
        if p!=pt:
            an.append((1,2))
        if q!=pt:
            an.append((2,1))
    else:
        if p==q:
            pt=p^1
            if r!=pt:
                an.append((n,n-1))
            else:
                an.append((n-1,n))
        else:
            an.append((2,1))
            pt=p^1
            if r!=pt:
                an.append((n,n-1))
            else:
                an.append((n-1,n))
    print(len(an))
    for u,v in an:
        print(u,v)
        
        