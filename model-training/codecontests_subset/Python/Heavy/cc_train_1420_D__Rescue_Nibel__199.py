import sys,math
from collections import Counter,deque,defaultdict
from bisect import bisect_left,bisect_right 
mod = 10**9+7
INF = float('inf')
def inp(): return int(sys.stdin.readline())
def inpl(): return list(map(int, sys.stdin.readline().split()))

mod = 998244353
class Combination:
    """
    comb = Combination(1000000)
    print(comb(5, 3))  # 10
    """
    def __init__(self, n_max, mod=10**9+7):
        self.mod = mod
        self.modinv = self.make_modinv_list(n_max)
        self.fac, self.facinv = self.make_factorial_list(n_max)

    def __call__(self, n, r):
        return self.fac[n] * self.facinv[r] % self.mod * self.facinv[n-r] % self.mod

    def make_factorial_list(self, n):
        fac = [1]
        facinv = [1]
        for i in range(1, n+1):
            fac.append(fac[i-1] * i % self.mod)
            facinv.append(facinv[i-1] * self.modinv[i] % self.mod)
        return fac, facinv

    def make_modinv_list(self, n):
        # 0からnまでのmod逆元のリストを返す O(n)
        modinv = [0] * (n+1)
        modinv[1] = 1
        for i in range(2, n+1):
            modinv[i] = self.mod - self.mod//i * modinv[self.mod%i] % self.mod
        return modinv
comb = Combination(300100,mod)
n,k = inpl()
se = set()
seg = []
for _ in range(n):
    a,b = inpl()
    a,b = a-1,b-1
    se.add(a); se.add(b)
    seg.append([a,b])
l = list(se)
l.sort()
ln = len(l)
d = {}
for i,x in enumerate(l):
    d[x] = i
for i,(a,b) in enumerate(seg):
    seg[i][0] = d[a]
    seg[i][1] = d[b]

imo = [[0]*(ln+1) for _ in range(2)]
for a,b in seg:
    imo[0][a] += 1
    imo[1][b+1] += 1
res = 0
pre = 0
for i in range(ln):
    pl = imo[0][i]; mi = imo[1][i]
    now = pl-mi + pre
    if now >= k:
        res += comb(now,k) 
    if pre - mi >= k:
        res -= comb(pre-mi,k)
    pre = now
    res %= mod
print(res)