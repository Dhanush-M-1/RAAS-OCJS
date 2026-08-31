import sys
import math
import itertools
import collections

def getdict(n):
    d = {}
    if type(n) is list or type(n) is str:
        for i in n:
            if i in d:
                d[i] += 1
            else:
                d[i] = 1
    else:
        for i in range(n):
            t = ii()
            if t in d:
                d[t] += 1
            else:
                d[t] = 1
    return d
def divs(n, start=1):
    r = []
    for i in range(start, int(math.sqrt(n) + 1)):
        if (n % i == 0):
            if (n / i == i):
                r.append(i)
            else:
                r.extend([i, n // i])
    return r
def cdiv(n, k): return n // k + (n % k != 0)
def ii(): return int(input())
def mi(): return map(int, input().split())
def li(): return list(map(int, input().split()))
def lcm(a, b): return abs(a*b) // math.gcd(a, b)
def wr(arr): return ''.join(map(str, arr))
def revn(n): return int(str(n)[::-1])
def prime(n):
    if n == 2: return True
    if n % 2 == 0 or n <= 1: return False
    sqr = int(math.sqrt(n)) + 1
    for d in range(3, sqr, 2):
        if n % d == 0: return False
    return True
def convn(number, base=3):
    newnumber = ''
    while number > 0:
        newnumber = str(number % base) + newnumber
        number //= base
    return newnumber


n, k = mi()
ids = li()
n = int(math.sqrt(2 * k + 0.25) - 0.5)
if k == 1:
    print(ids[0])
elif abs(math.sqrt(2 * k + 0.25) - 0.5 - n) < 10 ** -6:
    print(ids[:n][-1])
else:
    print(ids[k - 1 - n * (n + 1) // 2])
