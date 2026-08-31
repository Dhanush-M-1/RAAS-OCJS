N, M, *C = map(int, open(0).read().split())
MOD = 10**9 + 7
F = [0]*(N+1)
for c in C:
    F[c-1] = 1

a = 1; b = 0
for i in range(N):
    if F[i]:
        a, b = 0, a
    else:
        a, b = ((a+b) % MOD), a
print(a)