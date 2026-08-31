n,a=int(input()),list(map(int,input().split()))
g=0
from math import gcd
for i in a:g=gcd(i,g)
if g!=1:print("not coprime")
else:

    primes=list(range(10**6+1))
    primes[0]=primes[1]=0
    for i in range(2,10**6+1):
        if primes[i]==i:
            for j in range(2*i,10**6,i):primes[j]=i
    ps=set()
    for x in a:
        while x !=1:
            t=primes[x]
            if t in ps:print("setwise coprime");exit()
            ps.add(t)
            while x%t==0:x//=t
    print("pairwise coprime")