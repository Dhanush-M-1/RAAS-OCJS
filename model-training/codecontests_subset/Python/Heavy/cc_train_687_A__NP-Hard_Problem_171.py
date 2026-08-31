from collections import deque
lin = input().split()
n, m = int(lin[0]), int(lin[1])

graph = [[] for i in range(n)]
# graph2 = n * [[]] equivalent
for i in range(m):
    curr = input().split()
    u, v = int(curr[0]) - 1, int(curr[1]) - 1
    graph[u].append(v)
    graph[v].append(u)
## Graph built, do bfs to check if its bipartite.

color = [-1 for i in range(n)]


def bipartiteBFS(source: int) -> bool:
    dq = deque()
    dq.appendleft(source)
    color[source] = 0 # start coloring w 0.
    colorable = True
    while len(dq) > 0 and colorable:
        curr = dq.popleft() ## curr is like a parent
        for neighbor in graph[curr]:
            if color[neighbor] == - 1:
                dq.append(neighbor)
                color[neighbor] = 1 - color[curr]
            elif (color[neighbor] == color[curr]): # not bipartite
                colorable = False
    return colorable
ans = True
for node_value in range(n): 
    if color[node_value] == -1:
        ans &= bipartiteBFS(node_value)

if (ans):
    set1 = [index for index in range(len(color)) if color[index]]
    set2 = [index for index in range(len(color)) if not color[index]]
    print (len(set1))
    for num in set1:
        print (num+1, end = ' ')
    print()
    print (len(set2))
    for num in set2:
        print (num+1, end = ' ')
    print()
else: 
    print(-1)

		  			 		   	 			 			 				 	 	