for _ in range(int(input())):
    s=input()
    ar=["AD","WS"]
    nr=[[],[]]
    for e in s:
        if(e in ar[0]):nr[0].append(e)
        else: nr[1].append(e)
    b,c=[float('inf')]*2,[float('inf')]*2
    for i in range(2):
        sm=[0]
        for el in nr[i]:sm+=[sm[-1]+(1 if el==ar[i][0] else -1)]
        for _ in range(2):
            f=sm.index(min(sm))
            l=len(sm)-1-sm[::-1].index(max(sm))
            bse=sm[l]-sm[f]+1
            bst=bse
            if(bse>=3 and l<f):bst-=1
            b[i]=min(b[i],bse)
            c[i]=min(c[i],bst)
            for j in range(len(sm)):sm[j]*=-1
    print(min(b[0]*c[1],b[1]*c[0]))
