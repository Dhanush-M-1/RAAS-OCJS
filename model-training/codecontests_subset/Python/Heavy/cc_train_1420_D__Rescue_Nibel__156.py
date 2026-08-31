import io, os
input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

MOD = 998244353

n, k = map(int, input().split())
a = [tuple(map(int, input().split())) for _ in range(n)]

fac = [1] * (n + 1)
for i in range(2, n + 1):
    fac[i] = fac[i - 1] * i % MOD
ifac = [1] * (n + 1)
ifac[n] = pow(fac[n], MOD - 2, MOD)
for i in range(n - 1, 1, -1):
    ifac[i] = ifac[i + 1] * (i + 1) % MOD
comb = lambda n, k: fac[n] * ifac[k] % MOD * ifac[n - k] % MOD if 0 <= k <= n else 0

e = [s * 2 for s, _ in a] + [e * 2 + 1 for _, e in a]
e.sort()

cur = ways = 0
for t in e:
    if t % 2:
        cur -= 1
    else:
        ways += comb(cur, k - 1)
        cur += 1
print(ways % MOD)
