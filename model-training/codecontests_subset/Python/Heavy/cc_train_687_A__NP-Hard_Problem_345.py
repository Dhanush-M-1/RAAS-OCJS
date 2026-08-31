from sys import stdin
from collections import *


class graph:
    # initialize graph
    def __init__(self, gdict=None):
        if gdict is None:
            gdict = defaultdict(list)
        self.gdict, self.edges, self.arr1, self.arr2, self.visit = gdict, [], defaultdict(int), defaultdict(
            int), defaultdict(int)

    # find edges
    def find_edges(self):
        return self.edges

    # Get verticies
    def get_vertices(self):
        return list(self.gdict.keys())

    # add vertix
    def add_vertix(self, node):
        self.gdict[node] = []

    # add edge
    def add_edge(self, node1, node2):
        self.gdict[node1].append(node2)
        self.gdict[node2].append(node1)
        self.edges.append([node1, node2])

    def bfs(self, i):
        queue = deque([[i, 1]])

        self.visit[i], self.arr1[i] = 1, 1

        while queue:
            # dequeue parent vertix
            s, level = queue.popleft()

            # enqueue child vertices
            for i in self.gdict[s]:
                if self.visit[i] == 0:
                    queue.append([i, level + 1])
                    self.visit[i] = 1
                    if level % 2:
                        self.arr2[i] = 1
                    else:
                        self.arr1[i] = 1


n, m = map(int, input().split())
graph1, e1, e2 = graph(), 0, 0
for i in range(m):
    u, v = map(int, input().split())
    graph1.add_edge(u, v)

for i in range(1, n + 1):
    if not graph1.visit[i]:
        graph1.bfs(i)

out1, out2 = list(graph1.arr1.keys()), list(graph1.arr2.keys())
# print(out1, out2)

for i, j in graph1.edges:
    if graph1.arr1[i] and graph1.arr2[j] or graph1.arr1[j] and graph1.arr2[i]:
        continue
    else:
        exit(print(-1))

print(len(out1))
print(*out1)
print(len(out2))
print(*out2)
