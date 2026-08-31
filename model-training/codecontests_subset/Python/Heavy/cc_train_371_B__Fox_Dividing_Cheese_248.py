from math import *
b = input()
b = b.split()
n = int(b[0])
m = int(b[1])
b = [2,3,5]
a = []
c = []
for x in range(10):
    a.append(0)
    c.append(0)
for x in b:
    l = n
    while (l%x)==0:
        a[x]+=1
        l/=x
    l = m
    while (l%x)==0:
        c[x]+=1
        l/=x
ans = 0
for x in b:
    if a[x]!=c[x]:
        l = abs(a[x]-c[x])
        ans+=l
        if a[x]<c[x]:
            for y in range(l):
                m/=x
        else:
            for y in range(l):
                n/=x
if n==m: print(ans)
else: print(-1)