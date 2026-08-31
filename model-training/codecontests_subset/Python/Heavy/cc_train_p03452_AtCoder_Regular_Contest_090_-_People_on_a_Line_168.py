N, M = map(int, input().split())
LRD = [list(map(int, input().split())) for i in range(M)]


class WeightedUnionFind:
    def __init__(self, n):
        self.par = [i for i in range(n+1)]
        self.rank = [0] * (n+1)
        self.weight = [0] * (n+1)

    # 検索
    def find(self, x):
        if self.par[x] == x:
            return x
        else:
            y = self.find(self.par[x])
            self.weight[x] += self.weight[self.par[x]]
            self.par[x] = y
            return y

    # 重さの検索
    def weighting(self, x):
        self.find(x)
        return self.weight[x]

    # 併合
    def union(self, x, y, w):
        px = self.find(x)
        py = self.find(y)
        if px != py:
            if self.rank[px] < self.rank[py]:
                self.par[px] = py
                self.weight[px] = w - self.weight[x] + self.weight[y]
            else:
                self.par[py] = px
                self.weight[py] = -w - self.weight[y] + self.weight[x]
                if self.rank[px] == self.rank[py]:
                    self.rank[px] += 1

    # 同じ集合に属するか
    def same(self, x, y):
        return self.find(x) == self.find(y)

    # 各頂点間の絶対距離
    def diff(self, x, y):
        return self.weight[x] - self.weight[y]

wuf = WeightedUnionFind(N)
for l, r, d in LRD:
    if wuf.same(l, r):
        if wuf.diff(l, r) != d:
            print("No")
            break
    else:
        wuf.union(l, r, d)
else:
    print("Yes")