import sys
input=sys.stdin.readline
 
t=int(input())
for _ in range(t):
    input()
    k,n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    c=0
    d=0
    an=[]
    sign=0
    while c<n and d<m:
        if a[c]==0:
            k+=1
            an.append(a[c])
            c+=1
            if c==n:
                break
        elif b[d]==0:
            k+=1
            an.append(b[d])
            d+=1
            if d==m:
                break
        elif a[c]<=k:
            an.append(a[c])
            c+=1
        elif b[d]<=k:
            an.append(b[d])
            d+=1
        else:
            sign=1
            break
    if c==n:
        while d<m:
            if b[d]==0:
                k+=1
                an.append(b[d])
                d+=1
                if d==m:
                    break
            elif b[d]<=k:
                an.append(b[d])
                d+=1
            else:
                sign=1
                break
    else:
        while c<n:
            if a[c]==0:
                k+=1
                an.append(a[c])
                c+=1
                if c==n:
                    break
            elif a[c]<=k:
                an.append(a[c])
                c+=1
            else:
                sign=1
                break
    if sign:
        print(-1)
    else:
        print(*an)