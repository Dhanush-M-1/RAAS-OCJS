import sys
from collections import deque
input = sys.stdin.buffer.readline

N, M = map(int, input().split())
adj = [[] for _ in range(N+1)]
for _ in range(M):
    l, r, d = map(int, input().split())
    adj[l].append((r, d))
    adj[r].append((l, -d))

seen = ['!'] * (N+1)
for i in range(1, N+1):
    if seen[i] == '!':
        que = deque()
        seen[i] = 0
        que.append(i)
        while que:
            v = que.popleft()
            for u, d in adj[v]:
                if seen[u] == '!':
                    seen[u] = seen[v] + d
                    que.append(u)
                else:
                    if seen[v] + d != seen[u]:
                        print('No')
                        exit()
print('Yes')
