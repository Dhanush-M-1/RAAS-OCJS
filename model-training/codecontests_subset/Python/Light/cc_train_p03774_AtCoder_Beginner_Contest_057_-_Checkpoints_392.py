N, M = map(int, input().split())

a, b = [0] * N, [0] * N
for i in range(N):
    a[i], b[i] = map(int, input().split())

c, d = [0] * M, [0] * M
for i in range(M):
    c[i], d[i] = map(int, input().split())

for i in range(N):
    ans = min(range(M), key=lambda j: abs(a[i] - c[j]) + abs(b[i] - d[j]))
    print(ans + 1)
