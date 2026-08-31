from bisect import *
import math
for _ in range(int(input())):
    n,m=map(int,input().split())
    arr=list(map(int,input().split()))
    xs=list(map(int,input().split()))
    pre=[]
    for i in range(n):
        try:
            pre.append((pre[-1][0]+arr[i],i))
        except:
            pre.append((arr[i],i))
    cy=pre[-1][0]
    pp=[]
    m=pre[0][0]
    idx=0
    for x,y in pre:
        if x>m:
            m=x
            idx=y
        pp.append((m,idx))
    pp.sort(key=lambda x:x[0])
    pr=[]
    for i in pp:
        pr.append(i[0])
    m=pr[-1]
    out=[]
    for i in xs:
        if i<=m:
            idx=bisect_left(pr,i)
            out.append(pp[idx][1])
        else:
            if cy>0:
                r=math.ceil((i-m)/cy)
                t=n*r+pp[bisect_left(pr,i-cy*r)][1]
                out.append(t)
            else:
                out.append(-1)
    print(*out)