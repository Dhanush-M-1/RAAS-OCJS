from collections import defaultdict
import sys
input = sys.stdin.buffer.readline
MOD = 998244353

n, k = map(int, input().split())
add, rmv, pos = defaultdict(int), defaultdict(int), set([])
for _ in range(n):
    l, r = map(int, input().split())
    add[l], rmv[r] = add[l]+1, rmv[r]+1
    pos.add(l); pos.add(r)

fac, ifac = [1]*(n+1), [1]*(n+1)
for i in range(1, n+1):
    fac[i] = (fac[i-1]*i)%MOD
    ifac[i] = pow(fac[i], MOD-2, MOD)

def comb(m, r):
    return (((fac[m]*ifac[m-r])%MOD)*ifac[r])%MOD

pos = list(sorted(list(pos)))
cur, sm = 0, 0
for p in pos:
    if cur >= k: sm = (sm-comb(cur, k))%MOD
    cur += add[p]
    if cur >= k: sm = (sm+comb(cur, k))%MOD
    cur -= rmv[p]
print(sm)
