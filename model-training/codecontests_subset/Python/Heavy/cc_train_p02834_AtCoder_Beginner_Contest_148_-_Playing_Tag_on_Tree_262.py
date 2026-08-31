n, u, v = map(int, input().split())
g = [[] for _ in range(n)]
for i in range(n - 1):
    a, b = map(int, input().split())
    g[a - 1].append(b - 1)
    g[b - 1].append(a - 1)
d1 = [-1] * n
d1[u - 1] = 0
s = [u - 1]
while s:
    d = s.pop()
    for node in g[d]:
        if d1[node] == -1:
            s.append(node)
            d1[node] = d1[d] + 1
d2 = [-1] * n
d2[v - 1] = 0
s = [v - 1]
while s:
    d = s.pop()
    for node in g[d]:
        if d2[node] == -1:
            s.append(node)
            d2[node] = d2[d] + 1
m = 0
mi = 0
for i in range(n):
    if d1[i] < d2[i]:
        if m < d2[i]:
            m = d2[i]
            mi = i
print(m - 1)
