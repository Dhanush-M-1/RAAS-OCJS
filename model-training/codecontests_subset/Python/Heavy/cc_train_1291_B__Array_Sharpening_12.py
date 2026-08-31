import sys
input=sys.stdin.buffer.readline #FOR READING PURE INTEGER INPUTS (space separation ok)

t=int(input())
for _ in range(t):
    n=int(input())
    a=[int(x) for x in input().split()]
    
    mid1=(n-1)//2
    mid2=n//2
    
    if n%2==1 or (n%2==0 and a[mid1]!=a[mid2]):
        ok=True
        for i in range(mid1,-1,-1):
            if a[i]<i:
                ok=False
                break
        x=0
        for i in range(n-1,mid2-1,-1):
            if a[i]<x:
                ok=False
                break
            x+=1
        if ok:
            print('Yes')
        else:
            print('No')
    else: #a[mid1]==a[mid2]
        a[mid1]-=1
        ok=True
        for i in range(mid1,-1,-1):
            if a[i]<i:
                ok=False
                break
        x=0
        for i in range(n-1,mid2-1,-1):
            if a[i]<x:
                ok=False
                break
            x+=1
        if ok:
            print('Yes')
            continue
    
        a[mid1]+=1
        a[mid2]-=1
        ok=True
        for i in range(mid1,-1,-1):
            if a[i]<i:
                ok=False
                break
        x=0
        for i in range(n-1,mid2-1,-1):
            if a[i]<x:
                ok=False
                break
            x+=1
        if ok:
            print('Yes')
        else:
            print('No')