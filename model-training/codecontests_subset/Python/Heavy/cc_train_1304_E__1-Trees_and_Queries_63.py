import sys, os
 
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
        return self.func(self._data[depth][begin], self._data[depth][end - (1 << depth)])
 
 
class LCA:
    def __init__(self, root, graph):
        self.time = [-1] * len(graph)
        self.path = [-1] * len(graph)
        P = [-1] * len(graph)
        t = -1
        dfs = [root]
        while dfs:
            node = dfs.pop()
            self.path[t] = P[node]
            self.time[node] = t = t + 1
            for nei in graph[node]:
                if self.time[nei] == -1:
                    P[nei] = node
                    dfs.append(nei)
        self.rmq = RangeQuery(self.time[node] for node in self.path)
 
    def __call__(self, a, b):
        if a == b:
            return a
        a = self.time[a]
        b = self.time[b]
        if a > b:
            a, b = b, a
        return self.path[self.rmq.query(a, b)]
         
inp = [int(x) for x in sys.stdin.buffer.read().split()]; ii = 0
 
n = inp[ii]; ii += 1
coupl = [[] for _ in range(n)]
for _ in range(n - 1):
    u = inp[ii] - 1; ii += 1
    v = inp[ii] - 1; ii += 1
    coupl[u].append(v)
    coupl[v].append(u)
 
root = 0
lca = LCA(root, coupl)
depth = [-1]*n
depth[root] = 0
bfs = [root]
for node in bfs:
    for nei in coupl[node]: 
        if depth[nei] == -1:
            depth[nei] = depth[node] + 1
            bfs.append(nei)
 
def dist(a,b):
    c = lca(a,b)
    return depth[a] + depth[b] - 2 * depth[c]
 
q = inp[ii]; ii += 1
out = []
for _ in range(q):
    x = inp[ii] - 1; ii += 1
    y = inp[ii] - 1; ii += 1
    a = inp[ii] - 1; ii += 1
    b = inp[ii] - 1; ii += 1
    k = inp[ii]; ii += 1
 
    shortest_odd = 10**9 + 11
    shortest_even = 10**9 + 10
    for d in [dist(a,b), dist(a,x) + dist(y,b) + 1, dist(a,y) + dist(x,b) + 1, 
        dist(a,b) + dist(b,x) + dist(y,b) + 1,
        dist(b,a) + dist(a,x) + dist(y,a) + 1]:
        if d & 1:
            shortest_odd = min(shortest_odd, d)
        else:
            shortest_even = min(shortest_even, d)
 
    if k & 1:
        out.append(b'YES' if shortest_odd <= k else b'NO')
    else:
        out.append(b'YES' if shortest_even <= k else b'NO')
os.write(1, b'\n'.join(out))