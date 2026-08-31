n, r0, g0 = map(int, input().split())
edges = [tuple(map(int, input().split())) for _ in range(n-1)]

connects = [[] for i in range(n+1)]
for e in edges:
    connects[e[0]].append(e[1])
    connects[e[1]].append(e[0])    

rL, gL = [-1]*(n+1), [-1]*(n+1)
rL[r0], gL[g0] = 0, 0

from collections import deque
rQ, gQ = deque([r0]), deque([g0])

for L, Q in [(rL, rQ), (gL, gQ)]:
    while Q:
        node = Q.popleft()
        for ni in connects[node]:
            if L[ni] == -1:
                L[ni] = L[node] + 1
                ### print((node, L[node]), (ni, L[ni]))
                Q.append(ni)

print(max(gL[i] for i in range(1, n+1) if rL[i] < gL[i]) - 1)