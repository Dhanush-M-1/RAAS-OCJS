n, u, v, *L = map(int, open(0).read().split())
dist_f_v = [-1] * n
con = [[] for _ in range(n)]
for s, t in zip(*[iter(L)] * 2):
	con[s - 1].append(t - 1)
	con[t - 1].append(s - 1)
dist_f_v[v - 1] = 0
q = [v - 1]
while q:
	cur = q.pop()
	for nxt in con[cur]:
		if dist_f_v[nxt] < 0:
			dist_f_v[nxt] = dist_f_v[cur] + 1
			q.append(nxt)
dist_f_u = [-1] * n
dist_f_u[u - 1] = 0
q = [u - 1]
m = 0
while q:
	cur = q.pop()
	m = max(m, dist_f_v[cur])
	for nxt in con[cur]:
		if dist_f_u[nxt] > -1:
			continue
		if dist_f_u[cur] + 1 < dist_f_v[nxt]:
			dist_f_u[nxt] = dist_f_u[cur] + 1
			q.append(nxt)
		elif dist_f_u[cur] + 1 == dist_f_v[nxt]:
			dist_f_u[nxt] = dist_f_u[cur] + 1
print(m - 1)
