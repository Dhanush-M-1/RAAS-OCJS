# 重み付きUnion-Findデータ構造
class WeightedUnionFind:
    def __init__(self, numV):
        self.pars = list(range(numV))
        self.ranks = [0] * numV
        self.weights = [0] * numV

    def find(self, x):
        if self.pars[x] == x:
            return x
        else:
            parXOld = self.pars[x]
            self.pars[x] = self.find(parXOld)
            self.weights[x] += self.weights[parXOld]
            return self.pars[x]

    def union(self, x, y, wt):
        wtX = self.getWeight(x)
        wtY = self.getWeight(y)
        x = self.find(x)
        y = self.find(y)
        if x == y:
            return wtY == wtX+wt
        wt += wtX - wtY
        if self.ranks[x] < self.ranks[y]:
            self.pars[x] = y
            self.weights[x] = -wt
        else:
            self.pars[y] = x
            self.weights[y] = wt
            if self.ranks[x] == self.ranks[y]:
                self.ranks[x] += 1
        return True

    def same(self, x, y):
        return self.find(x) == self.find(y)

    def getWeight(self, x):
        self.find(x)
        return self.weights[x]

    def getDiff(self, x, y):
        if self.find(x) == self.find(y):
            return self.getWeight(y) - self.getWeight(x)
        else:
            return float('inf')


N, M = map(int, input().split())

WUF = WeightedUnionFind(N)
ans = 'Yes'
for _ in range(M):
    L, R, D = map(int, input().split())
    if not WUF.union(L-1, R-1, D):
        ans = 'No'

print(ans)
