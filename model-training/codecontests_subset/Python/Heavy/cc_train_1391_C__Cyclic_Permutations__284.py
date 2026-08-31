
def modfac(n, MOD):
 
    f = 1
    factorials = [1]
    for m in range(1, n + 1):
        f *= m
        f %= MOD
        factorials.append(f)
    inv = pow(f, MOD - 2, MOD)
    invs = [1] * (n + 1)
    invs[n] = inv
    for m in range(n, 1, -1):
        inv *= m
        inv %= MOD
        invs[m - 1] = inv
    return factorials, invs


def modnCr(n,r,mod,fac,inv): 
    return fac[n] * inv[n-r] * inv[r] % mod

n = int(input())
ans = 0
mod = 10**9+7

fac,inv = modfac(n+10,mod)

for i in range(0,n):
    ans += modnCr(n-1,i,mod,fac,inv)
    ans %= mod
print ((fac[n] - ans) % mod)
