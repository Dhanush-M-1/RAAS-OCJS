import io
import os

MAX_N = 3 * 10 ** 5
MOD = 998244353


def modInverse(a, p):
    # Fermat's little theorem, a**(p-1) = 1 mod p
    # assert a % p != 0
    return pow(a, p - 2, p)


# Precompute all factorials: i!
fact = [1]
for i in range(1, MAX_N + 1):
    fact.append((fact[-1] * i) % MOD)

# Precompute all inverse factorials: 1 / (i!)
invFact = [0] * (MAX_N + 1)
invFact[MAX_N] = modInverse(fact[MAX_N], MOD)
for i in range(MAX_N - 1, -1, -1):
    invFact[i] = (invFact[i + 1] * (i + 1)) % MOD
    assert fact[i] * invFact[i] % MOD == 1

"""
# Precompute all inverses, 1 / i == (i - 1)! / i!
inv = [0] * (MAX_N + 1)
for i in range(1, MAX_N + 1):
    inv[i] = fact[i - 1] * invFact[i] % MOD
    assert inv[i] * i % MOD == 1
"""


def nCr(n, r):  # mod'd
    return (fact[n] * invFact[r] * invFact[n - r]) % MOD


def solve(N, K, LR):
    endpoints = []
    for l, r in LR:
        l -= 1
        r -= 1
        endpoints.append(2 * l + 0)
        endpoints.append(2 * r + 1)
    endpoints.sort()
    ans = 0
    overlaps = 0
    for tup in endpoints:
        x, kind = divmod(tup, 2)
        if kind == 0:
            if overlaps >= K - 1:
                ans += nCr(overlaps, K - 1)
                ans %= MOD
            overlaps += 1
        else:
            overlaps -= 1

    return ans


if __name__ == "__main__":
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

    N, K = [int(x) for x in input().split()]
    LR = [[int(x) for x in input().split()] for i in range(N)]
    ans = solve(N, K, LR)
    print(ans)
