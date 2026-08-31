N, M = map(int, input().split())
AB = []
for _ in range(N):
    a, b = map(int, input().split())
    AB.append((a, b))
CD = []
for _ in range(M):
    c, d = map(int, input().split())
    CD.append((c, d))
for a, b in AB:
    i = min(range(M), key=lambda i: abs(a - CD[i][0]) + abs(b - CD[i][1]))
    print(i + 1)
