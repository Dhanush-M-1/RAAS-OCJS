import sys
readline = sys.stdin.readline


class UF():
    def __init__(self, num):
        self.par = [-1]*num
        self.color = [0]*num
    def find(self, x):
        if self.par[x] < 0:
            return x
        else:
            stack = []
            while self.par[x] >= 0:
                stack.append(x)
                x = self.par[x]
            for xi in stack:
                self.par[xi] = x
            return x
    def col(self, x):
        return self.color[self.find(x)]
    def paint(self, x):
        self.color[self.find(x)] = 1
    def union(self, x, y):
        rx = self.find(x)
        ry = self.find(y)
        if rx != ry:
            if self.par[rx] > self.par[ry]:
                rx, ry = ry, rx
            self.par[rx] += self.par[ry]
            self.par[ry] = rx
            self.color[rx] |= self.color[ry]
            return True
        return False


N, M = map(int, readline().split())
MOD = 10**9+7
ans = []
T = UF(M)
for m in range(N):
    k, *x = map(int, readline().split())
    if k == 1:
        u = x[0]-1
        if not T.col(u):
            ans.append(m+1)
            T.paint(u)
    else:
        u, v = x[0]-1, x[1]-1
        if T.col(u) and T.col(v):
            continue
        if T.union(u, v):
            ans.append(m+1)
    

print(pow(2, len(ans), MOD), len(ans))
print(' '.join(map(str, ans))) 