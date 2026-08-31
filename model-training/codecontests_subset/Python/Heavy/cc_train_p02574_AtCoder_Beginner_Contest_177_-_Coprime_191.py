import math


def primes(N):
    p = [False, False] + [True] * (N - 1)
    for i in range(2, int(N ** 0.5) + 1):
        if p[i]:
            for j in range(i * 2, N + 1, i):
                p[j] = False
    return [i for i in range(N + 1) if p[i]]


N = int(input())
A = list(map(int, input().split()))
maxA = max(A) + 1
g, Ac = A[0], [0] * maxA
P = primes(maxA)

for a in A:
    Ac[a] += 1

ans = "pairwise"
for p in P:
    if sum(Ac[p:maxA:p]) > 1:
        ans = "setwise"
for a in A:
    g = math.gcd(g, a)
print(ans if g == 1 else "not", "coprime")
