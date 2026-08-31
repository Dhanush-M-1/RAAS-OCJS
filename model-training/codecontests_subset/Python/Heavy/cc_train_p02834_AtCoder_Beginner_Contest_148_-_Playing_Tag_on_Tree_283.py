import sys
input = sys.stdin.readline

# 再帰上限を引き上げる
sys.setrecursionlimit(10**6)

# G:graph, cr:current node, seen:is seen?, dist:out;each distance
def dfs(G,cr,seen,dist):
	seen[cr] = 1
	for i in G[cr]: #G[cr]から行ける各頂点へ
		if seen[i] == 0: #まだ通っていなかったら
			dist[i] = dist[cr]+1
			dfs(G,i,seen,dist)


n,u,v = (int(x) for x in input().split())

u,v = u-1,v-1

a = [[] for i in range(n)]

for i in range(n-1):
	# 配列indexは0開始だからinputは-1
	l,m = (int(x)-1 for x in input().split())
	a[l].append(m)
	a[m].append(l)

# v視点のdistを調べる
dist_u = [0]*n
dist_v = [0]*n

dfs(a,u,[0]*n,dist_u)
# u視点のdistを調べる
dfs(a,v,[0]*n,dist_v)

for i in range(n):
	if dist_u[i] >= dist_v[i]: # vが追いつける距離なら
		dist_v[i] = -1

print(max(dist_v) - 1)