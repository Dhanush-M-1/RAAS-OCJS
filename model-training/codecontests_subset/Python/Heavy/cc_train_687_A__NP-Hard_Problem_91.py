n,m = list(map(int,input().split()))
graph = [[]for _ in range(n)]
color = [0]*n
for i in range(m):
    a,b = list(map(int,input().split()))
    graph[a-1].append(b-1)
    graph[b-1].append(a-1)
for i in range(n):
    if color[i]:
        continue
    color[i] = 1
    queue = [i]
    while queue:
        u = queue.pop()
        for v in graph[u]:
            if color[v]:
                if color[v]==color[u]:
                    print(-1)
                    exit(0)
            else:
                color[v] = 3-color[u]
                queue.append(v)
arr1 = []
arr2 = []
for i in range(len(color)):
    if color[i]==1:
        arr1.append(i+1)
    else:
        arr2.append(i+1)
print(len(arr1))
print(*arr1)
print(len(arr2))
print(*arr2)