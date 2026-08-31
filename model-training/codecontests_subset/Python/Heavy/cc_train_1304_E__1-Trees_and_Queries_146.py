import sys


class RangeMinQuery:
    # O(nlog(n)) construction/space, O(1) range minimum query
    def __init__(self, data):
        self._data = [list(data)]
        n = len(self._data[0])

        # self._data[i][j] stores the min of the segment [j, j + 2 ** i] where i is in [1,2,4,8,...,log(N)]
        w = 1
        while 2 * w <= n:
            prev = self._data[-1]
            self._data.append([min(prev[j], prev[j + w]) for j in range(n - 2 * w + 1)])
            w *= 2

    def query(self, begin, end):
        # Take the min of the overlapping intervals [begin, begin + 2**depth] and [end - 2**depth, end]
        depth = (end - begin).bit_length() - 1
        return min(self._data[depth][begin], self._data[depth][end - (1 << depth)])


class LCA:
    def __init__(self, graph, root=1):
        # Euler tour representation recording every visit to each node in the DFS
        self.eulerTour = []
        # Whether a node is visited and if so, their first index in the euler tour
        self.time = [None] * len(graph)
        # Depth of each node to the root
        self.depth = [None] * len(graph)
        self.depth[root] = 0

        # DFS
        stack = [root]
        while stack:
            node = stack.pop()
            self.eulerTour.append(node)
            if self.time[node] is None:
                self.time[node] = len(self.eulerTour) - 1
                for nbr in graph[node]:
                    if self.time[nbr] is None:
                        self.depth[nbr] = self.depth[node] + 1
                        stack.append(node)
                        stack.append(nbr)

        self.rmq = RangeMinQuery(self.time[node] for node in self.eulerTour)

    def lca(self, u, v):
        a = self.time[u]
        b = self.time[v]
        if a > b:
            a, b = b, a
        return self.eulerTour[self.rmq.query(a, b + 1)]

    def dist(self, u, v):
        return self.depth[u] + self.depth[v] - 2 * self.depth[self.lca(u, v)]

    # TODO isAncestor using euler tour?


def solve(N, edges, queries):

    graph = [[] for i in range(N + 1)]
    for e in edges:
        graph[e[0]].append(e[1])
        graph[e[1]].append(e[0])

    tree = LCA(graph)

    ans = []
    for x, y, a, b, k in queries:
        d_ab = tree.dist(a, b)
        d_axyb = tree.dist(a, x) + 1 + tree.dist(y, b)
        d_ayxb = tree.dist(a, y) + 1 + tree.dist(x, b)
        if any(d <= k and (k - d) % 2 == 0 for d in [d_ab, d_axyb, d_ayxb]):
            ans.append("YES")
        else:
            ans.append("NO")
    return "\n".join(ans)


if __name__ == "__main__":
    input = sys.stdin.readline
    N = int(input())
    edges = []
    for i in range(N - 1):
        edges.append(list(map(int, input().split())))
    Q = int(input())
    queries = []
    for i in range(Q):
        queries.append(list(map(int, input().split())))
    ans = solve(N, edges, queries)
    print(ans)
