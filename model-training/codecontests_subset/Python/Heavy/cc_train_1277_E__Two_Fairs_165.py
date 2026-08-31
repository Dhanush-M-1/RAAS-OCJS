import sys
ans = []

for _ in range(int(input())):
    n, m, a, b = map(int, input().split())
    a -= 1
    b -= 1

    adj = [[] for _ in range(n)]
    for u, v in (map(int, sys.stdin.readline().split()) for _ in range(m)):
        adj[u-1].append(v-1)
        adj[v-1].append(u-1)

    visited = [0]*n
    visited[a] = 3
    visited[b] = 3

    stack = [a]
    while stack:
        v = stack.pop()
        for dest in adj[v]:
            if visited[dest] & 1:
                continue
            visited[dest] |= 1
            stack.append(dest)

    stack = [b]
    while stack:
        v = stack.pop()
        for dest in adj[v]:
            if visited[dest] & 2:
                continue
            visited[dest] |= 2
            stack.append(dest)

    ans.append(visited.count(1) * visited.count(2))

print(*ans, sep='\n')
