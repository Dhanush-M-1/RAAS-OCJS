n,k=map(int,input().split())
a,b,t=[],[],[]
for i in range(0,n):
    tm,c,d=map(int,input().split())
    if c==1 and d==1:
        t.append(tm)
    elif c==1 and d==0:
        a.append(tm)
    elif c==0 and d==1:
        b.append(tm)
if (len(t)+len(a))<k or (len(t)+len(b))<k:
    print(-1)        
else:
    t.sort()
    a.sort()
    b.sort()
    i=0
    j=0
    ans=0
    fga=0
    fgt=0
    while(k!=0):
        if len(a)<=j or len(b)<=j:
            fga=1
            break
        elif len(t)<=i: 
            fgt=1
            break
        elif t[i]>(a[j]+b[j]):
            ans+=a[j]+b[j]
            j+=1
        elif t[i]<=(a[j]+b[j]):
            ans+=t[i]
            i+=1
        k-=1   
    if fga==1 and fgt==0:
        while(k!=0):
            ans+=t[i]
            i+=1
            k-=1
    elif fga==0 and fgt!=0:
        while(k!=0):
            ans+=(a[j]+b[j])
            j+=1
            k-=1
    print(ans)        
