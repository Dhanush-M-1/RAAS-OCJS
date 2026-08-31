# SHRi GANESHA    author: Kunal Verma #
import os
import sys
from bisect import bisect_left, bisect_right

from collections import Counter, defaultdict
from functools import reduce

from io import BytesIO, IOBase
from itertools import combinations
from math import gcd, inf, sqrt, ceil, floor


#sys.setrecursionlimit(2*10**5)
def lcm(a, b):
    return (a * b) // gcd(a, b)


'''
mod = 10 ** 9 + 7
fac = [1]
for i in range(1, 2 * 10 ** 5 + 1):
    fac.append((fac[-1] * i) % mod)
fac_in = [pow(fac[-1], mod - 2, mod)]
for i in range(2 * 10 ** 5, 0, -1):
    fac_in.append((fac_in[-1] * i) % mod)
fac_in.reverse()


def comb(a, b):
    if a < b:
        return 0
    return (fac[a] * fac_in[b] * fac_in[a - b]) % mod
'''

MAXN = 1000004
spf = [0 for i in range(MAXN)]
def sieve():
    spf[1] = 1
    for i in range(2, MAXN):
        spf[i] = i
    for i in range(4, MAXN, 2):
        spf[i] = 2

    for i in range(3, ceil(sqrt(MAXN))):
        if (spf[i] == i):
            for j in range(i * i, MAXN, i):
                if (spf[j] == j):
                    spf[j] = i


def getFactorization(x):
    ret = Counter()
    while (x != 1):
        ret[spf[x]] += 1
        x = x // spf[x]
    return ret


def printDivisors(n):
    i = 2
    z = [1, n]
    while i <= sqrt(n):
        if (n % i == 0):
            if (n / i == i):
                z.append(i)
            else:
                z.append(i)
                z.append(n // i)
        i = i + 1
    return z


def create(n, x, f):
    pq = len(bin(n)[2:])
    if f == 0:
        tt = min
    else:
        tt = max
    dp = [[inf] * n for _ in range(pq)]
    dp[0] = x
    for i in range(1, pq):
        for j in range(n - (1 << i) + 1):
            dp[i][j] = tt(dp[i - 1][j], dp[i - 1][j + (1 << (i - 1))])
    return dp


def enquiry(l, r, dp, f):
    if l > r:
        return inf if not f else -inf
    if f == 1:
        tt = max
    else:
        tt = min
    pq1 = len(bin(r - l + 1)[2:]) - 1
    return tt(dp[pq1][l], dp[pq1][r - (1 << pq1) + 1])


def SieveOfEratosthenes(n):
    prime = [True for i in range(n + 1)]
    p = 2
    while (p * p <= n):
        if (prime[p] == True):
            for i in range(p * p, n + 1, p):
                prime[i] = False
        p += 1
    x = []
    for i in range(2, n + 1):
        if prime[i]:
            x.append(i)
    return x
def main():
    class dsu:
        def __init__(self, n):
            self.parent = [0] * (n + 1)
            self.size = [0] * (n + 1)
            self.sp = [0] * (n + 1)

        def make_set(self, v):
            self.parent[v] = v
            self.size[v] = 1

        def union_set(self, a, b):
            a = self.find_set(a)
            b = self.find_set(b)
            if (a != b):
                if self.size[a] < self.size[b]:
                    a, b = b, a
                self.parent[b] = a

                self.size[a] += self.size[b]
                self.sp[a] += self.sp[b]

        def find_set(self, v):
            if (v == self.parent[v]):
                return v
            self.parent[v] = self.find_set(self.parent[v])
            return self.parent[v]

    n, m, k = map(int, input().split())
    x = [int(X) for X in input().split()]
    spec = [0] * (n + 1)
    for i in x:
        spec[i] = 1
    ed = []
    for i in range(m):
        u, v, w = map(int, input().split())
        ed.append((w, u, v))
    ed.sort()
    xx = dsu(n)
    for i in x:
        xx.sp[i] = 1
    for i in range(1, n + 1):
        xx.make_set(i)
    adj = [[] for i in range(n + 1)]
    for i in ed:
        if xx.find_set(i[1]) != xx.find_set(i[2]):
            if xx.sp[xx.find_set(i[1])] + xx.sp[xx.find_set(i[2])] == k:
                an = i[0]
                break
            else:
                xx.union_set(i[1], i[2])
                u, v = i[1:3]
                adj[u].append(v)
                adj[v].append(u)
    print(*[an] * k)





# Fast IO Region
BUFSIZE = 8192


class FastIO(IOBase):
    newlines = 0

    def __init__(self, file):
        self._fd = file.fileno()
        self.buffer = BytesIO()
        self.writable = "x" in file.mode or "r" not in file.mode
        self.write = self.buffer.write if self.writable else None

    def read(self):
        while True:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            if not b:
                break
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines = 0
        return self.buffer.read()

    def readline(self):
        while self.newlines == 0:
            b = os.read(self._fd, max(os.fstat(self._fd).st_size, BUFSIZE))
            self.newlines = b.count(b"\n") + (not b)
            ptr = self.buffer.tell()
            self.buffer.seek(0, 2), self.buffer.write(b), self.buffer.seek(ptr)
        self.newlines -= 1
        return self.buffer.readline()

    def flush(self):
        if self.writable:
            os.write(self._fd, self.buffer.getvalue())
            self.buffer.truncate(0), self.buffer.seek(0)


class IOWrapper(IOBase):
    def __init__(self, file):
        self.buffer = FastIO(file)
        self.flush = self.buffer.flush
        self.writable = self.buffer.writable
        self.write = lambda s: self.buffer.write(s.encode("ascii"))
        self.read = lambda: self.buffer.read().decode("ascii")
        self.readline = lambda: self.buffer.readline().decode("ascii")


sys.stdin, sys.stdout = IOWrapper(sys.stdin), IOWrapper(sys.stdout)
input = lambda: sys.stdin.readline().rstrip("\r\n")

if __name__ == '__main__':
    main()