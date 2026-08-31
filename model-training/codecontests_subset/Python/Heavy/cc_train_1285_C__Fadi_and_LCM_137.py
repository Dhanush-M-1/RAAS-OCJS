from math import gcd, inf
import itertools


def factors(n):
    return set(itertools.chain.from_iterable((i, n//i) for i in range(1, int(n**0.5)+1) if n % i == 0))


def coprime(a, b):
    return gcd(a, b) == 1


x = int(input())

if x == 1:
    print(1, 1)
else:
    f = list(factors(x))
    mx = inf
    min_pair = None
    for i in range(len(f) - 1):
        a = f[i]
        b = x // a
        
        if a != b and coprime(a, b):
            mxx = max(a, b)
            if mxx < mx:
                mx = mxx
                min_pair = (a, b)
    print(*min_pair)