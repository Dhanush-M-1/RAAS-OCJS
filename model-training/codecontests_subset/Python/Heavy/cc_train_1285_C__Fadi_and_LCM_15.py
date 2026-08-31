import sys
def fastio():
    from io import StringIO
    from atexit import register
    global input
    sys.stdin = StringIO(sys.stdin.read())
    input = lambda : sys.stdin.readline().rstrip('\r\n')
    sys.stdout = StringIO()
    register(lambda : sys.__stdout__.write(sys.stdout.getvalue()))
fastio()

def debug(*var, sep = ' ', end = '\n'):
    print(*var, file=sys.stderr, end = end, sep = sep)

INF = 10**20
MOD = 10**9 + 7
I = lambda:list(map(int,input().split()))
from math import gcd
from math import ceil
from collections import defaultdict as dd, Counter
from bisect import bisect_left as bl, bisect_right as br

M = 1000010
x, = I()
fac = dd(int)
primes = []
p = [1] * M
temp = x
for i in range(2, M):
    if not p[i]: continue

    for j in range(2 * i, M, i):
        p[j] = 0
    primes.append(i)

f = True
for i in primes:
    if x % i: continue
    fac[i] = 0
    while x % i == 0:
        fac[i] += 1
        x //= i
    f = False

fac[x] += 1
fac[temp//x] += 1

ok = []
for i in fac:
    ok.append(i**fac[i])

ans = INF
k = len(ok)
for i in range(1, 2 ** k):
    cur = 1
    for j in range(k):
        if (i >> j) & 1:
            cur *= ok[j]
    ta = cur
    if temp % ta: continue
    tb = temp // ta
    if max(ta, tb) < ans:
        ans = max(ta, tb)
        a = ta
        b = tb
print(a, b)
