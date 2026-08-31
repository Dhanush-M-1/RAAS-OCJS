from itertools import chain, combinations
from operator import mul
from functools import reduce
import sys


def primes(n):
    primfac = [1]
    d = 2
    while d*d <= n:
        while (n % d) == 0:
            if primfac[-1] % d!=0:
                primfac.append(d)  # supposing you want multiple factors repeated
            else:
                primfac[-1]*=d
            n //= d
        d += 1
    if n > 1:
       primfac.append(n)
    return primfac

X = int(input())
ps = list(sorted(primes(X)[1:]))

ans = 10**13
amin=1
bmin=1
def rec(i,j,l):
    if l == 0:
        global ans,amin,bmin
        if max(i,j)<ans:
            ans=max(i,j)
            amin=i
            bmin=j
        return
    rec(i*ps[-l],j,l-1)
    rec(i,j*ps[-l],l-1)
rec(1,1,len(ps))
print(amin,bmin)

