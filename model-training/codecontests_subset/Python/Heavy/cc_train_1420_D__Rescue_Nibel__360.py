import sys
input = sys.stdin.readline
N,K = map(int,input().split())
LR = [tuple(map(int,input().split())) for i in range(N)]
MOD = 998244353

MAXN = N+5
fac = [1,1] + [0]*MAXN
finv = [1,1] + [0]*MAXN
inv = [0,1] + [0]*MAXN
for i in range(2,MAXN+2):
    fac[i] = fac[i-1] * i % MOD
    inv[i] = -inv[MOD%i] * (MOD // i) % MOD
    finv[i] = finv[i-1] * inv[i] % MOD

def comb(n,r):
    if n < r: return 0
    if n < 0 or r < 0: return 0
    return fac[n] * (finv[r] * finv[n-r] % MOD) % MOD

arr = []
for l,r in LR:
    arr.append(l*2)
    arr.append(r*2+1)
arr.sort()

ans = 0
sz = 0
for e in arr:
    if e%2:
        sz -= 1
    else:
        if sz+1 >= K:
            ans += comb(sz, K-1)
            ans %= MOD
        sz += 1
print(ans)
