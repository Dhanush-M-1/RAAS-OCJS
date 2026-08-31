input=__import__('sys').stdin.readline
from math import log
from math import pow
n,q=map(int,input().split())
l=list(map(int,input().split()))
ans=[0]*33
for i in range(n):
    x=int(log(l[i],2))
    ans[x]+=1
for _ in range(q):
    y=int(input())
    out=0
    for i in range(30,-1,-1):
        z=0
        if(y>0):
            if(y>>i):
                z=min(y>>i,ans[i])

            out+=z
            y=y-int(pow(2,i))*z
        else:
            break
    if (y > 0):
        out = -1
    print(out)
 