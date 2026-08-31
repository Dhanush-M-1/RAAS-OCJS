from sys import stdin
readline = stdin.readline
MOD = 998244353
MAXN = 300005

fac = [1]*MAXN

for i in range(1, MAXN):
    fac[i] = fac[i-1]*i%MOD


def C(k, n):
    if k > n or k < 0:
        return 0
    return fac[n]*pow(fac[k]*fac[n-k]%MOD,MOD-2,MOD)%MOD

n, k = map(int, readline().split())
nodes = []
for _ in range(n):
    l, r = map(int, readline().split())
    nodes.append(2*l)
    nodes.append(2*r+1)

nodes = sorted(nodes)

sum_lights = 0
ans = 0

for node in nodes:
    if node%2:
        sum_lights -= 1
        continue

    ans += C(k-1, sum_lights)
    ans %= MOD
    sum_lights += 1

print(ans)

