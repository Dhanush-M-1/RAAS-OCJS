N, M = map(int, input().split())
X = [list(map(int, input().split())) for _ in range(M)]

class WeightedUnionFind:
    def __init__(self, n):
        self.par = list(range(n))
        self.rank = [0] * n
        self.weight = [0] * n
        
    def find(self, x):
        if self.par[x] == x:
            return x
        else:
            y = self.find(self.par[x])
            self.weight[x] += self.weight[self.par[x]]
            self.par[x] = y
            return y
        
    def unite(self, x, y, w):
        px = self.find(x)
        py = self.find(y)
        
        if px == py:
            return True
        
        if self.rank[px] == self.rank[py]:
            self.rank[px] += 1
        elif self.rank[px] < self.rank[py]:
            px, py = py, px
            x, y = y, x
            w *= -1

        self.par[py] = px
        self.weight[py] = self.weight[x] - self.weight[y] - w
                
    def same(self, x, y):
        return self.find(x) == self.find(y)
    
    def diff(self, x, y):
        return self.weight[x] - self.weight[y]

t = WeightedUnionFind(N + 1)
for l, r, d in X:
    if t.same(l, r):
        if t.diff(l, r) != d:
            print('No')
            break
    else:
        t.unite(l, r, d)
else:
    print('Yes')

