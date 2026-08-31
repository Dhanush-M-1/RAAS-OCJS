t=int(input())
for _ in range(t):
    n=int(input())
    a=list(map(int,input().split()))
    g,s,b,c=0,0,0,0
    i=0
    ct=[]
    while i<n:
        t=a[i]
        c=0
        while t==a[i]:
            c=c+1
            i=i+1
            if i==n:
                break
        ct.append(c)
    for i in range(len(ct)):
        if i==0:
            g=ct[i]
        else:
            if s<=g:
                s=s+ct[i]
            else:
                if b<=g or (g+s+b)<n//2:
                    if g+s+b+ct[i]>n//2:
                        break
                    else:
                        b=b+ct[i]
        
    if g==0 or b==0 or s==0 or (g+s+b)>n//2 or b<=g or s<=g:
        print(0,0,0)
    else:
        print(g,s,b)