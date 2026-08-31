def reduce(n):
    a = []
    while n>0:
        n=n//2
        a.append(n)
    return a
n,k = list(map(int,input().split()))
a = list(map(int,input().split()))
b = list(set(a))
b.sort()
from collections import defaultdict
c,d = defaultdict(int),defaultdict(int)
c[0]=0
d[0]=0
for i in a:
    c[i]+=1
    d[i]=0
for i in b:
    p,q = c[i],d[i]
    t = reduce(i)
    t.reverse()
    w=1
    while t!=[]:
        r = t.pop()
        x = c[r]
        if x>=k:
            w=w+1
            continue
        else:
            if (x+p)<=k:
                c[r]=x+p
                d[r]+=(w*p)
            else:
                z = k-x
                c[r]=k
                d[r]+=z*w
            w=w+1
mi = float("inf")
for i in c:
    if c[i]>=k:
        if d[i]<mi:
            mi=d[i]
print(mi)
