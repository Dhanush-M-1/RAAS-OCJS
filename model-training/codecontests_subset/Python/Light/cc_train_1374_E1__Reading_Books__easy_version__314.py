[N,K] = list(map(int, input().split()))
L = [[[] for i in range(2)]for j in range(2)]
for i in range(N):
    [t, a, b] = list(map(int, input().split()))
    L[a][b].append(t)

INF = int(1e12)

for i in range(2):
    for j in range(2):
        L[i][j].sort()
        for k in range(K - len(L[i][j])):
            L[i][j].append(INF)

ans = INF
now = 0
for i in range(K):
    now += L[1][1][i]
ans = min(ans, now)
for i in range(K):
    now -= L[1][1][K-i-1]
    now += L[1][0][i]
    now += L[0][1][i]
    ans = min (ans, now)
if ans >= INF: ans = -1
print(ans)
