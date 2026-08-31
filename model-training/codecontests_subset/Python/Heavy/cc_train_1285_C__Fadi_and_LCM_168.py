''' Fadi and LCM
'''
from math import sqrt


def checkprime(i, plist):
    rt = sqrt(i)
    for p in plist:
        if i % p == 0:
            return False
        if p > rt:
            plist.append(i)
            return True
    plist.append(i)
    return True


def factorise(X):
    plist = []
    factors = []
    f = 2
    rt = sqrt(X)
    if f <= rt:
        factor = 1
        while X % f == 0 and X != 0:
            factor *= f
            X //= f
        if factor > 1: factors.append(factor)
    
    f = 3
    while f <= rt:
        if checkprime(f, plist):
            factor = 1
            while X % f == 0 and X != 0:
                factor *= f
                X //= f
            if factor > 1: factors.append(factor)
        f += 2
    if X > 1: factors.append(X)
    return factors



''' routine '''

X = int(input())
if X == 1:
    print(1, 1)
else:
    factors = factorise(X)
    factors.sort()
    # print(factors)
    a, b = 1, 1

    size = len(factors)
    bins = [format(i, f'0{size}b') for i in range(2**(size))]
    # print(bins)
    opti = 10**12
    optia, optib = 0, 0
    for bn in bins:
        a, b = 1, 1
        for n, bit in enumerate(bn):
            if bit == '1':
                a *= factors[n]
            else:
                b *= factors[n]
        if max(a, b) < opti:
            opti = max(a, b)
            optia, optib = a, b
    print(optia, optib)