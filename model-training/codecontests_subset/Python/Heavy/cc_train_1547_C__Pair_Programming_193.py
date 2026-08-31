import sys
input=sys.stdin.readline
from collections import defaultdict as dc
from collections import Counter
from bisect import bisect_right, bisect_left,bisect
import math
from operator import itemgetter
from heapq import heapify, heappop, heappush
for _ in range(int(input())):
    input()
    k,n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    p=[0]*(n+m)
    f=1
    i,j=0,0
    c=0
    while(i<n and j<m):
        if a[i]==b[j]:
            if a[i]==0:
                p[c]=a[i]
                i+=1
                c+=1
                k+=1
            else:
                if a[i]<=k:
                    p[c]=a[i]
                    i+=1
                    c+=1
                else:
                    f=0
                    break
        else:
            if a[i]<=k and b[j]<=k:
                if a[i]<=b[j]:
                    p[c]=a[i]
                    c+=1
                    if a[i]==0:
                        k+=1
                    i+=1
                else:
                    p[c]=b[j]
                    c+=1
                    if b[j]==0:
                        k+=1
                    j+=1
            elif a[i]<=k:
                p[c]=a[i]
                c+=1
                if a[i]==0:
                    k+=1
                i+=1
            elif b[j]<=k:
                p[c]=b[j]
                c+=1
                if b[j]==0:
                    k+=1
                j+=1
            else:
                f=0
                break
    if f:
        while(i<n):
            if a[i]<=k:
                p[c]=a[i]
                c+=1
                if a[i]==0:
                    k+=1
                i+=1
            else:
                f=0
                break
        while(j<m):
            if b[j]<=k:
                p[c]=b[j]
                c+=1
                if b[j]==0:
                    k+=1
                j+=1
            else:
                f=0
                break
    if f:        
        print(*p)
    else:
        print(-1)