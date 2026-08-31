n = int(input())

neigh = [[] for _ in range(n)]
for i in range(n-1):
	u, v = map(int, input().split())
	u -= 1
	v -= 1
	neigh[u].append(v)
	neigh[v].append(u)

no = False
for i in range(n):
	if len(neigh[i]) == 2:
		no = True

if no:
	print('NO')
else:
	print('YES')
