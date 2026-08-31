from sys import stdin
from math import factorial
mod = 998244353

n, k = map(int, stdin.readline().split())
start = []
end = []
f = [1] * (n + 1)
inf = [1] * (n + 1)

for i in range(2, n + 1):
    f[i] = (i * f[i - 1]) % mod
inf[n] = pow(f[n], mod - 2, mod)
for i in range(n - 1, 1, -1):
    inf[i] = ((i + 1) * inf[i + 1]) % mod

comb = lambda x, y: (f[x] * inf[y] * inf[x-y]) % mod if x >= y else 0 

for _ in range(n):
    l, r = map(int, stdin.readline().split())
    start.append(l)
    end.append(r)

total = [2*i for i in start] + [2*i+1 for i in end]
total.sort()
cur = 0
ans = 0

for i in total: 
    if i % 2 == 1:
        cur -=1
        cur %= mod
    else:
        ans += comb(cur, k - 1) % mod 
        cur += 1
        cur %= mod
        ans %= mod
print(ans % mod)