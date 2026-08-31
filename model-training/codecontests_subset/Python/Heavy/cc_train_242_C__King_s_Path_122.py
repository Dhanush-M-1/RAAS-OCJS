from collections import deque as Q

"""
242C King's Path
"""
x0, y0, x1, y1 = [int(i) for i in input().split(' ')]
n = int(input())
graph = {}
nX = [-1,0,1,-1,1,-1,0,1]
nY = [-1,-1,-1,0,0,1,1,1]
for i in range(n):
    r, a, b = [int(i) for i in input().split(' ')]
    # Add all allowed squares to the graph with distance -1, also signaling that they havent been
    # visited. And that if unvisitable should return -1
    for j in range(a,b+1):
        graph[(r,j)] = -1

graph[(x0, y0)] = 0
q = Q([(x0, y0)])
while q:
    c = q.popleft()
    for i in range(8):
        neighbour = (c[0]+nX[i], c[1]+nY[i])
        if neighbour in graph and graph[neighbour] == -1:
            q.append(neighbour)
            graph[neighbour] = graph[c] + 1

print(graph[x1, y1])
