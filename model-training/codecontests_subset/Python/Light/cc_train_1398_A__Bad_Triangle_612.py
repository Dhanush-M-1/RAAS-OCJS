for _ in range(int(input())):
    n=int(input())
    d={}
    l=[int(i) for i in input().split()]
    mn=10000000000000
    idx=0
    for i in range(n):
        if l[i]<mn:
            mn=l[i]
            idx=i
            
    d[idx]=l[idx]
    mn=10000000000000
    idx=-1
    for i in range(n):
        if i not in d:
            if l[i]<mn:
                mn=l[i]
                idx=i
    d[idx]=l[idx]
    c=max(l)
    d[l.index(c)]=c
    r=sorted(d.keys())
    p=sorted(d.values())
    if p[0]+p[1]>p[-1]:
        print(-1)
    else:
        for i in r:
            print(i+1,end=' ')
        print()    
            
    
    
    