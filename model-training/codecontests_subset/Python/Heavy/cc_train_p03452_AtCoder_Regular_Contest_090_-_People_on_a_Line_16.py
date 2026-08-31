N,M = map(int,input().split())
es = [[] for i in range(N)]
for i in range(M):
    l,r,d = map(int,input().split())
    l,r = l-1,r-1
    es[l].append((r,d))
    es[r].append((l,-d))

dist = [None] * N
for i in range(N):
    if dist[i] is not None: continue
    dist[i] = 0
    stack = [i]
    while stack:
        v = stack.pop()
        for to,d in es[v]:
            if dist[to] is None:
                dist[to] = dist[v] + d
                stack.append(to)
            else:
                if dist[to] != dist[v] + d:
                    print('No')
                    exit()
print('Yes')
