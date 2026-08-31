from collections import defaultdict as dc
import math
import sys
input=sys.stdin.readline
n=int(input())
l=list(map(int,input().split()))
if n>1:
    p=[0]*n
    q=[0]*(n-1)
    r=[0]*1
    for i in range(n-1):
        p[i]=-1*(l[i])*n
        q[i]=l[i]*(n-1)
    r[0]=-l[n-1]-n
    p[n-1]=n
    print(1,n-1)
    for i in range(n-2):
        print(q[i], end=" ")
    print(q[-1])
    print(1,n)
    for i in range(n-1):
        print(p[i],end=" ")
    print(p[-1])
    print(n,n)
    print(r[0])
else:
    print(1,1)
    print(0)
    print(1,1)
    print(0)
    print(1,1)
    print(-l[0])
    
    
    
    
    
    