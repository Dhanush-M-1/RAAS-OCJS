from math import *
t=int(input())
for _ in range(t):
    n=int(input())
    l=[]
    r=[]
    f=0
    for i in range(n):
        a,b=map(int,input().split())
        l.append(a)
        r.append(b)
    q=[r[0]]
    p=[l[0]]
    for i in range(1,n):
        p.append(l[i]-l[i-1])
        q.append(r[i]-r[i-1])
    for i in range(n):
        k=p[i]-q[i]
        if p[i]<0 or q[i]<0 or k<0:
            f=1
            break
            
    if f==0:
        print('YES')
    else:
        print("NO")
    
        
        