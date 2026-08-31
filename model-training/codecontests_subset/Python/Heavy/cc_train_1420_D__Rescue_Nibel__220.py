def COMinit():
  fac[0] = fac[1] = 1
  finv[0] = finv[1] = 1
  inv[1] = 1
  for i in range(2,n+1):
    fac[i] = fac[i - 1] * i % mod
    inv[i] = mod - inv[mod%i] * (mod // i) % mod
    finv[i] = finv[i - 1] * inv[i] % mod
  return fac, inv, finv


def COM(n, k):
  if n < k: return 0
  if n < 0 or k < 0: return 0
  return fac[n] * (finv[k] * finv[n - k] % mod) % mod

import sys,os,io
input = sys.stdin.readline
#input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline
mod = 998244353
n, k = map(int, input().split())
fac = [0]*(n+1)
inv = [0]*(n+1)
finv = [0]*(n+1)
COMinit()
ans = 0
L,R = [0]*n,[0]*n
for i in range(n):
  L[i],R[i] = map(int, input().split())
compLR = {e: i+1 for i, e in enumerate(sorted(set(L+R)))}
for i in range(n):
  L[i] = compLR[L[i]]
  R[i] = compLR[R[i]]
on = [0]*(n*2+1)
off = [0]*(n*2+2)
for l,r in zip(L,R):
  on[l] += 1
  off[r+1] += 1
cum = 0
for i in range(1,n*2+1):
  cum -= off[i]
  for j in range(1,on[i]+1):
    old = k-j
    if 0<=old<=cum:
      ans += COM(cum,old)*COM(on[i],j)%mod
    ans %= mod
  cum += on[i]
print(ans)