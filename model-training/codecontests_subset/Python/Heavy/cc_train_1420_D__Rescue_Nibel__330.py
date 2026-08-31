class Combination:
    def __init__(self, n, MOD):
        self.fact = [1]
        for i in range(1, n + 1):
            self.fact.append(self.fact[-1] * i % MOD)
        self.inv_fact = [0] * (n + 1)
        self.inv_fact[n] = pow(self.fact[n], MOD - 2, MOD)
        for i in reversed(range(n)):
            self.inv_fact[i] = self.inv_fact[i + 1] * (i + 1) % MOD
        self.MOD = MOD

    def inverse(self, k):
        return (self.inv_fact[k] * self.fact[k - 1]) % self.MOD

    def factorial(self, k):
        return self.fact[k]

    def inverse_factorial(self, k):
        return self.inv_fact[k]

    def permutation(self, k, r):
        if k < r:
            return 0
        return (self.fact[k] * self.inv_fact[k - r]) % self.MOD

    def combination(self, k, r):
        if k < r:
            return 0
        return (self.fact[k] * self.inv_fact[k - r] * self.inv_fact[r]) % self.MOD


import heapq
import sys
input = sys.stdin.buffer.readline


n, k = map(int, input().split())
info = [list(map(int, input().split())) for i in range(n)]
MOD = 998244353
comb = Combination(5 * 10 ** 5, MOD)


info = sorted(info)
q = []
ans = 0
for l, r in info:
    while q and q[0] < l:
        heapq.heappop(q)
    heapq.heappush(q, r)
    cnt = len(q)
    ans += comb.combination(cnt - 1, k - 1)
    ans %= MOD
print(ans)