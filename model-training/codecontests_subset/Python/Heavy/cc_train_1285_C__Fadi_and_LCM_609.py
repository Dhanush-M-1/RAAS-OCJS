from math import floor, sqrt
try: 
    long
except NameError: 
    long = int
 
def fac(n):
    step = lambda x: 1 + (x<<2) - ((x>>1)<<1)
    maxq = long(floor(sqrt(n)))
    d = 1
    q = 2 if n % 2 == 0 else 3 
    while q <= maxq and n % q != 0:
        q = step(d)
        d += 1
    return [q] + fac(n // q) if q <= maxq else [n]
import collections
import bisect
n=int(input())
if n==1:
    print(1,1)
else:
    a=fac(n)
    b=collections.Counter(a)
    c=[]
    for i in b.keys():
        c.append(i**b[i])
    d=[1]
    e=[]
    for i in c:
        for j in d:
            e.append(j)
            e.append(i*j)
        d=e
        e=[]
    d.sort()
    k=bisect.bisect_left(d,int(n**0.5)+1)
    print(n//d[k],d[k])
