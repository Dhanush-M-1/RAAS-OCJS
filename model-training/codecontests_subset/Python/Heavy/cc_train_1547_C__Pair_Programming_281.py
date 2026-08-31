from math import *
from sys import *
input=stdin.readline

# map(int,input().split())

for _ in range(int(input())):
    input()
    k,n,m=map(int,input().split())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    i=0;j=0;l=[];cnt=1
    while (i<n) or (j<m):
        if i<n and a[i]==0:
            l.append(a[i])
            i+=1
            k+=1
            continue
        if j<m and b[j]==0:
            l.append(b[j])
            j+=1
            k+=1
            continue
        if i<n and k>=a[i]:
            l.append(a[i])
            i+=1
        elif j<m and k>=b[j]:
            l.append(b[j])
            j+=1
        else:
            cnt=0
            break
    if cnt:
        print(*l)
    else:print(-1)