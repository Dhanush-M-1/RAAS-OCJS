N, u, v = map(int, input().split())
tree = [[] for i in range(N + 1)]
for _ in range(N - 1):
	a, b = map(int, input().split())
	tree[a].append(b)
	tree[b].append(a)

def dfs(node):
	sta = [node]
	dis = [-1] * (N + 1)
	dis[node] = 0
	while sta:
		no = sta.pop()
		tempD = dis[no] + 1
		for tempN in tree[no]:
			if dis[tempN] < 0:
				dis[tempN] = tempD
				sta.append(tempN)
	else:
		return dis

disU = dfs(u)
disV = dfs(v)
ans = 0

for u_, v_ in zip(disU[1:], disV[1:]):
	if u_ < v_:
			ans = max(ans, v_)
else:
	print(ans - 1)