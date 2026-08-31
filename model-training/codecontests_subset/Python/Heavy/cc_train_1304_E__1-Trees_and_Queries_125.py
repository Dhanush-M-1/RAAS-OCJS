import sys

# LCA implementation found from:
# https://github.com/cheran-senthil/PyRival/blob/1971590e96b351288cacb09852896f2383862ab6/pyrival/graphs/lca.py
class RangeQuery:
    def __init__(self, data, func=min):
        self.func = func
        self._data = _data = [list(data)]
        i, n = 1, len(_data[0])
        while 2 * i <= n:
            prev = _data[-1]
            _data.append([func(prev[j], prev[j + i]) for j in range(n - 2 * i + 1)])
            i <<= 1

    def query(self, begin, end):
        depth = (end - begin).bit_length() - 1
        return self.func(
            self._data[depth][begin], self._data[depth][end - (1 << depth)]
        )


class LCA:
    def __init__(self, root, graph):
        self.time = [-1] * len(graph)
        self.path = []
        self.depth = [0] * len(graph)  # MODIFIED
        dfs = [root]
        while dfs:
            node = dfs.pop()
            self.path.append(node)
            if self.time[node] == -1:
                self.time[node] = len(self.path) - 1
                for nei in graph[node]:
                    if self.time[nei] == -1:
                        self.depth[nei] = self.depth[node] + 1  # MODIFIED
                        dfs.append(node)
                        dfs.append(nei)
        self.rmq = RangeQuery(self.time[node] for node in self.path)

    def lca(self, a, b):
        a = self.time[a]
        b = self.time[b]
        if a > b:
            a, b = b, a
        return self.path[self.rmq.query(a, b + 1)]


def solve(N, edges, queries):

    graph = [[] for i in range(N + 1)]
    for e in edges:
        graph[e[0]].append(e[1])
        graph[e[1]].append(e[0])

    L = LCA(1, graph)

    def lca(u, v):
        return L.lca(u, v)

    def getDist(u, v):
        return L.depth[u] + L.depth[v] - 2 * L.depth[lca(u, v)]

    ans = []
    for x, y, a, b, k in queries:
        d_ab = getDist(a, b)
        d_axyb = getDist(a, x) + 1 + getDist(y, b)
        d_ayxb = getDist(a, y) + 1 + getDist(x, b)
        if any(d <= k and (k - d) % 2 == 0 for d in [d_ab, d_axyb, d_ayxb]):
            ans.append("YES")
        else:
            ans.append("NO")
    return "\n".join(ans)


if __name__ == "__main__":
    N = int(input())
    edges = []
    for i in range(N - 1):
        edges.append(list(map(int, sys.stdin.readline().split())))
    Q = int(input())
    queries = []
    for i in range(Q):
        queries.append(list(map(int, sys.stdin.readline().split())))
    ans = solve(N, edges, queries)
    print(ans)
