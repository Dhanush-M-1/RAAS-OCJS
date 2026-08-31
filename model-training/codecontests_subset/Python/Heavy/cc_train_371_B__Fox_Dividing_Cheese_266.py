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
def cdiv(n, k): return n // k + (n % k != 0)
def ii(): return int(input())
def mi(): return map(int, input().split())
def li(): return list(map(int, input().split()))
def lcm(a, b): return abs(a*b) // math.gcd(a, b)
def wr(arr): return ''.join(map(str, arr))
def revn(n): return int(str(n)[::-1])
def prime(n):
    if n == 2:
        return True
    if n % 2 == 0 or n <= 1:
        return False
    sqr = int(math.sqrt(n)) + 1
    for d in range(3, sqr, 2):
        if n % d == 0:
            return False
    return True

a, b = mi()
if a == b:
    print(0)
else:
    ra, rb = [0] * 3, [0] * 3
    f = True
    while a != 1 and f:
        if a % 5 == 0:
            a //= 5
            ra[2] += 1
        elif a % 3 == 0:
            a //= 3
            ra[1] += 1
        elif a % 2 == 0:
            a //= 2
            ra[0] += 1
        else:
            f = False
    f = True
    while b != 1 and f:
        if b % 5 == 0:
            b //= 5
            rb[2] += 1
        elif b % 3 == 0:
            b //= 3
            rb[1] += 1
        elif b % 2 == 0:
            b //= 2
            rb[0] += 1
        else:
            f = False
    if a != b:
        print(-1)
    else:
        ans = 0
        for i in range(3):
            ans += abs(ra[i] - rb[i])
        print(ans)