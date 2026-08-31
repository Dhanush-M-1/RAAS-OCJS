n, m = map(int, input().split())
edges = {}
e = []
for i in range(m):
    u, v = map(int, input().split())
    e.append([u, v])
    if u in edges:
        edges[u].append(v)
    else:
        edges[u] = [v]

    if v in edges:
        edges[v].append(u)
    else:
        edges[v] = [u]

stack = [1]
visited = {1}
not_visited = set(range(2, n+1))
l1 = {1}
l2 = set()
while not_visited:
    if not stack:
        t = not_visited.pop()
        l1.add(t)
        visited.add(t)
        stack.append(t)

    p = stack.pop()

    if p in edges:
        isL1 = p in l1
        for child in edges[p]:
            if child not in visited:
                stack.append(child)
                visited.add(child)
                not_visited.remove(child)
                if isL1:
                    l2.add(child)
                else:
                    l1.add(child)

for edge in e:
    u, v = edge
    if (u not in l1 and v not in l1) or (u not in l2 and v not in l2):
        print('-1')
        break
else:
    print(len(l1))
    print(*l1)
    print(len(l2))
    print(*l2)
