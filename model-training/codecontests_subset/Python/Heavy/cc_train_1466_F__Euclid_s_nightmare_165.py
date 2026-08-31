import sys
input = sys.stdin.buffer.readline


class UnionFind:
    def __init__(self, n):
        self.parent = [-1] * n
        self.n = n
        self.cnt = n

    def root(self, x):
        if self.parent[x] < 0:
            return x
        else:
            self.parent[x] = self.root(self.parent[x])
            return self.parent[x]

    def merge(self, x, y):
        x = self.root(x)
        y = self.root(y)
        if x == y:
            return False
        if self.parent[x] > self.parent[y]:
            x, y = y, x
        self.parent[x] += self.parent[y]
        self.parent[y] = x
        self.cnt -= 1
        return True

    def is_same(self, x, y):
        return self.root(x) == self.root(y)

    def size(self, x):
        return -self.parent[self.root(x)]

    def count(self):
        return self.cnt

    def groups(self):
        res = [[] for _ in range(self.n)]
        for i in range(self.n):
            res[self.root(i)].append(i)
        return [group for group in res if group]


n, m = map(int, input().split())
info = [list(map(int, input().split())) for i in range(n)]
MOD = 10 ** 9 + 7


uf = UnionFind(m)
start = []
res = []
for i, (k, *vs) in enumerate(info):
    if len(vs) == 2:
        u, v = vs
        u -= 1
        v -= 1
        if not uf.is_same(u, v):
            uf.merge(u, v)
            res.append(i + 1)
    else:
        u = vs[0] - 1
        if start:
            if not uf.is_same(start[-1], u):
                uf.merge(start[-1], u)
                res.append(i + 1)
                start.append(u)
        else:
            res.append(i + 1)
            start.append(u)


print(pow(2, len(res), MOD), len(res))
print(*res)
