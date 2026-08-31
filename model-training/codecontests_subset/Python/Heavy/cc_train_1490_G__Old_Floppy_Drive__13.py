from collections import defaultdict
from bisect import bisect_right
import math
t=int(input())
for i in range(t):
    n,u=map(int,input().split())
    b=list(map(int,input().split()))
    a=list(map(int,input().split()))
    ans=[]
    s=sum(b)
    pre=[0]



    for j in range(n):
        pre.append(pre[-1]+b[j])
    st = [0]
    d = defaultdict(lambda:0)
    d[0]=0
    j=1
    while(j<=n):
        if pre[j]>st[-1]:
            st.append(pre[j])
            d[pre[j]]=j

        j+=1




    m=max(pre)
    res=[]
    for j in range(u):
        if pre[-1]<=0:
            if a[j]>m:
                res.append(-1)

            else:
                ind = d[st[bisect_right(st, a[j] - 1)]]
                res.append(ind-1)


        else:
            if a[j]<=m:
                k=0
                req=a[j]

            else:
                k=math.floor((a[j]-m)/pre[-1])
                req=a[j]-k*pre[-1]
                if req>m:
                    k+=1
                    req = a[j] - k * pre[-1]


            ind=d[st[bisect_right(st,req-1)]]
            res.append(max(0,k*n+ind-1))

    print(*res)




































