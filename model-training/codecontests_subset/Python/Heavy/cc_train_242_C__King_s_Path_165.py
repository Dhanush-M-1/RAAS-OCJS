def connect_point(graph, r, j, deg) :
    if (r - 1, j) in graph and deg < graph[r - 1, j][0]:
        graph[r - 1, j][0] = deg
        graph[r, j].append((r - 1, j))
    if (r + 1, j) in graph and deg < graph[r + 1, j][0]:
        graph[r + 1, j][0] = deg
        graph[r, j].append((r + 1, j))
    if (r, j - 1) in graph and deg < graph[r, j - 1][0]:
        graph[r, j - 1][0] = deg
        graph[r, j].append((r, j - 1))
    if (r, j + 1) in graph and deg < graph[r, j + 1][0]:
        graph[r, j + 1][0] = deg
        graph[r, j].append((r, j + 1))
    if (r - 1, j - 1) in graph and deg < graph[r - 1, j - 1][0]:
        graph[r - 1, j - 1][0] = deg
        graph[r, j].append((r - 1, j - 1))
    if (r - 1, j + 1) in graph and deg < graph[r - 1, j + 1][0]:
        graph[r - 1, j + 1][0] = deg
        graph[r, j].append((r - 1, j + 1))
    if (r + 1, j - 1) in graph and deg < graph[r + 1, j - 1][0]:
        graph[r + 1, j - 1][0] = deg
        graph[r, j].append((r + 1, j - 1))
    if (r + 1, j + 1) in graph and deg < graph[r + 1, j + 1][0]:
        graph[r + 1, j + 1][0] = deg
        graph[r, j].append((r + 1, j + 1))

def bfs(graph):
    res = -1
    deg = 1
    queue = []
    queue.append((sr, sc, 0))
    while queue :
        item = queue.pop(0)
        if item[0] == fr and item[1] == fc:
            res = item[2]
            break
        connect_point(graph, item[0], item[1], item[2] + 1)
        for i in graph[item[0], item[1]]:
            if type(i) == int:
                continue 
            queue.append((i[0], i[1], item[2] + 1))
        deg += 1
    return res



sr, sc, fr, fc = [int(i) for i in input().split()]
n = int(input())

graph = {}
graph[sr, sc] = [0]
graph[fr, fc] = [100000000000]
for i in range(n) :
    r, a, b = [int(i) for i in input().split()]
    for j in range(a, b + 1) :
        if (r, j) not in graph:
            graph[r, j] = [100000000000]
ret = bfs(graph)
#print(graph)
print(ret)

