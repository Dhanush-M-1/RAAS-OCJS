from collections import defaultdict as dc
import sys
input=sys.stdin.readline
for _ in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    x=dc(int)
    for i in l:
        x[i]+=1
    p=sorted(x.keys(), reverse=True)
    c=0
    i=0
    m=len(p)
    g=0
    s=0
    b=0
    #print(p)
    #print(x)
    if c+x[p[0]]<=n//2:
        g=x[p[0]]
        c+=x[p[0]]
    i=1
    while(c<n//2 and i<m and s<=g):
        if c+x[p[i]]<=n//2:
            s+=x[p[i]]
            c+=x[p[i]]
                    #print(x[p[i]])
        else:
            break
        i+=1
    while(c<n//2 and i<m):
        if c+x[p[i]]<=n//2:
            b+=x[p[i]]
            c+=x[p[i]]
            #print(p[i],x[p[i]])
        else:
            break
        i+=1
    if g==0 or s==0 or b==0:
        print(0,0,0)
    elif g>=s or g>=b:
        print(0,0,0)
    else:
        print(g,s,b)
                
        