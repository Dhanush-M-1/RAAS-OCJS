class WeightedUnionFind():
    def __init__(self, n):
        self.par = [i for i in range(n)]
        self.rank = [0 for i in range(n)]
        self.diff_weight = [0 for i in range(n)]

    def find(self, x):
        if self.par[x] == x:
            return x
        root = self.find(self.par[x])
        self.diff_weight[x] += self.diff_weight[self.par[x]]
        self.par[x] = root
        return self.par[x]

    def weight(self, x):
        self.find(x)
        return self.diff_weight[x]

    def diff(self, x, y):
        return self.weight(y)-self.weight(x)

    def unite(self, x, y, w):
        # y の root をくっつけるので。
        w += self.weight(x); w -= self.weight(y)
        x = self.find(x); y = self.find(y)
        if x == y:
            return False
        if self.rank[x] < self.rank[y]:
            self.par[x] = y
            w = -w
            self.diff_weight[x] = w
        elif self.rank[y] < self.rank[x]:
            self.par[y] = x
            self.diff_weight[y] = w
        else:
            self.par[y] = x
            self.diff_weight[y] = w
            self.rank[x] += 1
        return True

N, M = map(int, input().split())
wuf = WeightedUnionFind(N)
for i in range(M):
    l, r, d = map(int, input().split())
    l-=1;r-=1
    if wuf.find(l) == wuf.find(r):
        if wuf.diff(l, r) != d:
            print('No')
            break
    wuf.unite(l, r, d)
else:
    print('Yes')
