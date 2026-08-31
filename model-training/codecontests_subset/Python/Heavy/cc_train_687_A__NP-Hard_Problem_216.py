from sys import stdin
from collections import *


class graph:
    # initialize graph
    def __init__(self, gdict=None):
        if gdict is None:
            gdict = defaultdict(list)
        self.gdict, self.edges, self.colors = gdict, [], defaultdict(int)

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

        while queue:
            # dequeue parent vertix
            s, color = queue.popleft()

            if self.colors[s] == 0:
                self.colors[s] = color

            # enqueue child vertices
            for i in self.gdict[s]:
                if self.colors[i] == 0:
                    queue.append([i, 3 - color])


n, m = map(int, input().split())
graph1 = graph()

for i in range(m):
    u, v = map(int, input().split())
    graph1.add_edge(u, v)

for i in range(1, n + 1):
    if graph1.colors[i] == 0:
        graph1.bfs(i)

for i, j in graph1.edges:
    if graph1.colors[i] == graph1.colors[j]:
        exit(print(-1))

a, b = [i for i in range(n + 1) if graph1.colors[i] == 1], [i for i in range(n + 1) if graph1.colors[i] == 2]
print(len(a))
print(*a)
print(len(b))
print(*b)
