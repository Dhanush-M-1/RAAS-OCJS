


from collections import deque , defaultdict
n , m = map(int,input().split())
g = defaultdict(list)
visited = [-1]*(n + 1)
x , y = [] , []
for i in range(m):
    u , v = map(int,input().split())
    g[u].append(v)
    g[v].append(u)
    x.append(u)
    y.append(v)

def bfs(node,p):
    q = deque()
    q.append((node , p))
    while q :
        s1 , s2 = q.popleft()
        for i in g[s1]:
            if i != s2 and visited[i] == -1:
                visited[i] = 1 - visited[s1]
                q.append((i , s1))


for i in range(1 , n + 1):
    if visited[i] == -1:
        visited[i] = 1
        bfs(i , -1)
#print(visited)

for i in range(m):
    if visited[x[i]] == visited[y[i]]:
        print('-1')
        exit(0)

print(visited.count(0))
for i in range(n+1):
    if visited[i] == 0 :
        print(i , end = ' ')
print()
print(visited.count(1))
for i in range(n + 1):
    if visited[i] == 1 :
        print(i , end = ' ')






