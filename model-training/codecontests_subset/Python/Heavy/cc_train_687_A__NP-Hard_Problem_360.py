import sys
from collections import deque
input = sys.stdin.readline
n, m = map(int, input().split())
graph = {}
for i in range(m):
    a, b = map(int, input().split())
    if a not in graph:
        graph[a] = [b]
    else:
        graph[a].append(b)
    if b not in graph:
        graph[b] = [a]
    else:
        graph[b].append(a)

seen_0 = {}
seen_1 = {}
for i in range(1, n+1):
    if i in graph and i not in seen_0 and i not in seen_1:
        queue = deque([i])
        seen_0[i] = 1
        while queue:
            current = queue.popleft()
            for nxt in graph[current]:
                if current in seen_0 and nxt in seen_0:
                    print(-1)
                    sys.exit()
                if current in seen_1 and nxt in seen_1:
                    print(-1)
                    sys.exit()
                if nxt not in seen_0 and nxt not in seen_1:
                    if current in seen_0:
                        seen_1[nxt] = 1
                    else:
                        seen_0[nxt] = 1
                    queue.append(nxt)
print(len(seen_0))
print(*seen_0)
print(len(seen_1))
print(*seen_1)