for i in range(int(input())):
    input()
    k,n,m=map(int,input().split())
    a=[*map(int,input().split())]
    b=[*map(int,input().split())]
    l=[]
    q=n+m
    w,e,t=0,0,1
    while q:
        if w<n and a[w]==0:
            l+=[a[w]]
            w+=1
            k+=1
        elif w<n and a[w]<=k:
            l+=[a[w]]
            w+=1
        elif e<m and b[e]==0:
            l+=[b[e]]
            e+=1
            k+=1
        elif e<m and b[e]<=k:
            l+=[b[e]]
            e+=1
        else:t=0;break
        q-=1
    if l and t: print(*l)
    else:print(-1)