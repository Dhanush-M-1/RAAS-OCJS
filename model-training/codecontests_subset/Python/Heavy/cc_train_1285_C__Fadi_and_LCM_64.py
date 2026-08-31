from math import *
from itertools import combinations

def factor(x):
    f = [1]
    sq = sqrt(x)
    i = 2
    while i <= sq and x > 1:
        res = 1
        while x % i == 0:
            res *= i
            x //= i
        if res > 1:
            f.append(res)
        i += 1
    if x > 1:
        f.append(x)
    return f

def mul(a, i, j):
    res = 1
    for t in range(i, j + 1):
        res *= a[t]
    return res
def mu(a):
    res = 1
    for i in a:
        res *= i
    return res

X = int(input())
fa = factor(X)
le = len(fa)
fa.sort()
if le > 1:
    mV = X
    ans = [1, X]
    for i in range(1, le):
        comb = combinations(fa, i)
        for c in comb:
            a = mu(c)
            b = X // a
            if max(a, b) < mV:
                ans = [a, b]
                mV = max(a, b)
        i += 1
        
    print(' '.join(map(str, ans)))
else:
    print(1, X)
