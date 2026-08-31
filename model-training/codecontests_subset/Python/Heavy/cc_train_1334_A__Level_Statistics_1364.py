for i in range(int(input())):
    k=int(input())
    d=[]
    f=0
    e=0
    p,q=0,0
    for i in range(k):
        c=[]
        a,b=list(map(int,input().split()))
        if(b>a):
            f=1
        c.append(a)
        c.append(b)
        d.append(c)
        
    if(f==0):   
        for i in range(len(d)-1):
            if(d[i+1][1]>=d[i][1] and d[i+1][0]>=d[i][0]):
                p=d[i+1][1]-d[i][1]
                q=d[i+1][0]-d[i][0]
                if(p>q):
                    f=1
                    break
            else:
                f=1
                break
    if(f==0):
        print("YES")
    else:
        print("NO")