for _ in range(int(input())):
    k=input()
    k,n,m=list(map(int,input().split()))
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    L=[]
    lines=a.count(0)+b.count(0) +k
    i,j=0,0
    d=0
    if (max(a)<=lines) and (max(b)<=lines):
        Test=True
        while Test:
            if i<n:
                if a[i]>k:
                    d+=1
                while a[i]<=k:
                    L.append(a[i])
                    if a[i]==0:
                        k+=1
                        d-=1
                    i+=1
                    if i>=n:
                        break
            if j<m:
                if b[j]>k:
                    d+=1
                while b[j]<=k:
                    L.append(b[j])
                    if b[j]==0:
                        k+=1
                        d-=1
                    j+=1
                    if j>=m:
                        break
            if (i>=n and j>=m) or d>=2:
                break
        if Test and d<2:
            L=list(map(str,L))
            L=" ".join(L)
            print(L)
        else:
            print(-1)
    else:
        print(-1)