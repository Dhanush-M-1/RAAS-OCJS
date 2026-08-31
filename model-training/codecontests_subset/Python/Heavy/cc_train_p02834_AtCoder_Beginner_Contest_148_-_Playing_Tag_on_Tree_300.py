n, u, v = map(int, input().split())
edges = [[] for i in range(n)]
for _ in range(n - 1):
    a, b = map(int, input().split())
    edges[a - 1].append(b - 1)
    edges[b - 1].append(a - 1)

aolevel = [-1] * n
aolevel[v - 1] = 0
q = [v - 1]
while len(q) > 0:
    i = q.pop(0)
    for j in edges[i]:
        if aolevel[j] < 0:
            aolevel[j] = aolevel[i] + 1
            q.append(j)

ret = 0
takalevel = [-1] * n
takalevel[u - 1] = 0
q = [u - 1]
while len(q) > 0:
    i = q.pop(0)
    ret = max(ret, aolevel[i] - 1)
    if takalevel[i] < aolevel[i]:
        for j in edges[i]:
            if takalevel[j] < 0:
                takalevel[j] = takalevel[i] + 1
                q.append(j)

print(ret)
