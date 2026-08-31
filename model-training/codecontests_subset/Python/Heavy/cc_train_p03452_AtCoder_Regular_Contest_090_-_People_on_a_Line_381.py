from collections import defaultdict, deque

n,m = map(int,input().split())
edge = [[] for i in range(n)]
for i in range(m):
    l,r,d = map(int, input().split())
    edge[l-1].append((r-1,d))
    edge[r-1].append((l-1,-d))

dist = [0]*n
visited = [False]*n

for i in range(n):
    if visited[i]:
        continue
    q = deque()
    q.append((i,0))
    while q:
        to, d = q.popleft()
        if visited[to]:
            if dist[to] != d:
                print("No")
                exit()
        else:
            visited[to] = True
            dist[to] = d
            for ind, j in edge[to]:
                q.append((ind,d+j))

print("Yes")