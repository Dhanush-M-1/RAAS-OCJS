for _ in range(int(input())):
    q=input()
    k,n,m=[int(a) for a in input().split()]
    ar=list(map(int,input().split()))[:n]
    b=list(map(int,input().split()))[:m]
    t=ar.count(0)
    h=b.count(0)
    p=max(max(ar),max(b))
    if(k+t+h<p):
        print(-1)
    else:
        i=0
        j=0
        d=k
        w=0
        c=[]
        while(i<n and j<m):
            if(ar[i]<b[j]):
                if(ar[i]==0):
                    d=d+1
                c.append(ar[i])
                i=i+1
            else:
                if(b[j]==0):
                    d=d+1
                c.append(b[j])
                j=j+1
            if(c[-1]>d):
                w=1
                break
        while(i<n):
            if(ar[i]==0):
                d=d+1
            c.append(ar[i])
            i=i+1
            if(c[-1]>d):
                w=1
                break
        while(j<m):
            if(b[j]==0):
                d=d+1
            c.append(b[j])
            j=j+1
            if(c[-1]>d):
                w=1
                break
        if(w):
            print(-1)
        else:
            print(*c)
            
        
            
        
    
