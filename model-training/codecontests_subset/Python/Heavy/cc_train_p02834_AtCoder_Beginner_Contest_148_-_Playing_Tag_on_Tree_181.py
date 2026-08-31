import sys
sys.setrecursionlimit(10**6)
n, u, v = map(int, input().split())
adj = [[] for _ in range(n)]
for _ in range(n-1):
	a, b = map(int, input().split())
	adj[a-1].append(b-1)
	adj[b-1].append(a-1)

tkhs = [-1 for _ in range(n)]
aoki = [-1 for _ in range(n)]
tkhs[u-1], aoki[v-1] = 0, 0

def dfs(x, player):
	for y in adj[x]:
		if player[y] < 0:
			player[y] = player[x] + 1
			dfs(y, player)
	return

dfs(u-1, tkhs)
dfs(v-1, aoki)

ans = 0
for i in range(n):
	if tkhs[i] <= aoki[i] and len(adj[i]) > 1:
		ans = max(ans, aoki[i])

print(ans)