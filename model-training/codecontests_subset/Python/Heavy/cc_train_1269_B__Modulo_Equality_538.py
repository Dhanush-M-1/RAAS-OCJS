import sys
from collections import defaultdict
n,m=map(int,sys.stdin.readline().split())
a=list(map(int,sys.stdin.readline().split()))
b=list(map(int,sys.stdin.readline().split()))
a.sort()
b.sort()
dica,dicb=defaultdict(int),defaultdict(int)
for i in range(n):
    dica[a[i]]+=1
    dicb[b[i]]+=1
ans=float('inf')
for i in range(n):
    counta,countb=dica[a[i]],dicb[b[0]]
    if counta==countb:
        z=a[i]%m
        if z>b[0]:
            x=m+b[0]-z
        else:
            x=b[0]-z
        k,flag=i,True
        for j in range(n):
            if (a[k]+x)%m!=b[j]:
                flag=False
                break
            else:
                k+=1
                if k>=n:
                    k=0
        if flag:
            ans=min(ans,x)
        i+=counta
    else:
        i+=counta
print(ans)
