def readLine():
	a = input()
	return [int(i) for i in a.split(' ')]

nm = readLine()
n, m = nm[0], nm[1]
a = readLine()
pos = [0 for _ in range(n + 1)]
for i, val in enumerate(a):
	pos[val] = i
g = [[] for _ in range(n + 1)]
for i in range(m):
	xy = readLine()
	x, y = xy[0], xy[1]
	g[y].append(x)

used = [0 for _ in range(n + 1)]
used[a[n - 1]] = -1
ans = 0
l = []

for j in range(n):
	i = n - j - 1
	if used[a[i]] < len(l):
		l.append(a[i])
		for _, val in enumerate(g[a[i]]):
			used[val] = used[val] + 1
	else:
		ans = ans + 1

print(ans)