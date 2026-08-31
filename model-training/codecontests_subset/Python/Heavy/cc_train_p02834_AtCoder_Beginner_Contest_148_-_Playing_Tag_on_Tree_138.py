N, u, v = map(int, input().split())
tree = [[] for i in range(N + 1)]
for _ in range(N - 1):
	a, b = map(int, input().split())
	tree[a].append(b)
	tree[b].append(a)
    
def dfs(v: int, tree: int, N: int) -> int:
    dist = [-1] * (N + 1)
    dist[v] = 0
    stack = [v]
    
    while stack:
        now = stack.pop()
        dw = dist[now] + 1
        
        for ne in tree[now]:
            if dist[ne] >= 0:
                continue
            dist[ne] = dw
            stack.append(ne)
            
    return dist

T = dfs(u, tree, N)
A = dfs(v, tree, N)

ans = 0
for t, a in zip(T[1:], A[1:]):
    if t < a:
        ans = max(ans, a - 1)
print(ans)