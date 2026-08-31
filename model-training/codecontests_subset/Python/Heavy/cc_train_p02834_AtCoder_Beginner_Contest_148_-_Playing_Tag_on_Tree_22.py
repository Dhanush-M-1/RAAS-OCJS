N, u, v = map(int, input().split())
G = [[] for _ in range(N)]
for _ in range(N - 1):
    A, B = map(int, input().split())
    G[A - 1].append(B - 1)
    G[B - 1].append(A - 1)

isLeaf, dU, dV = [len(g) == 1 for g in G], [-1] * N, [-1] * N

for D, P in [(dU, u - 1), (dV, v - 1)]:
    S = [(P, 0)]
    while len(S) > 0:
        p, d = S.pop()
        D[p] = d
        for g in G[p]:
            if D[g] == -1:
                S.append((g, d + 1))

ans = 0
for i in range(N):
    if isLeaf[i] and dU[i] < dV[i]:
        ans = max(ans, dV[i] - 1)

print(ans)
