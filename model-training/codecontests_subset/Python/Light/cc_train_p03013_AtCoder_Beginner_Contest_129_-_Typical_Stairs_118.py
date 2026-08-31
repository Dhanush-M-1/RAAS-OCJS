N, M = map(int, input().split())
MOD = 10**9 + 7
F = [0]*(N+1)
for i in range(M):
    F[int(input())-1] = 1

a = 1; b = 0
for i in range(N):
    if F[i]:
        a, b = 0, a
    else:
        a, b = (a+b) % MOD, a
print(a)
