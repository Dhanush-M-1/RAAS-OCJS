import sys
from collections import Counter
input = sys.stdin.readline

def prime_factor(n):
    factors = []
    f = 2
    while n%2==0:
        factors.append(f)
        n//=f
    f = 3
    while f*f<=n:
        if n%f==0:
            factors.append(f)
            n//=f
        else:
            f+=2
    if n!=1:
        factors.append(n)
    return factors


n=int(input())
factor = prime_factor(n)
L=Counter(factor)
nf = []
for i in L:
    nf.append(pow(i,L[i]))

poss = [1]
for fact in nf:
    for v in poss[:]:
        if fact*v*fact*v<=n:
            poss.append(fact*v)
best = max(poss)
print(best,n//best)

