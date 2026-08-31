import io
import os

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

class DSU():
    def __init__(self, n):
        self.parent = list(range(n))
        self.size = [1] * n
        self.has_loop = [False] * n
        
    def find(self, v):
        if v == self.parent[v]:
            return v
        self.parent[v] = self.find(self.parent[v])
        return self.parent[v]
        
    def union(self, a, b):
        a = self.find(a)
        b = self.find(b)
        if a != b:
            if self.size[a] < self.size[b]:
                a, b = b, a
            self.parent[b] = a
            self.size[a] += self.size[b]
            self.has_loop[b] = self.has_loop[a] = (self.has_loop[a] or self.has_loop[b])

def solve():
    n, m = map(int, input().split())
    
    dsu = DSU(m)
    ans = []
    for i in range(n):
        k, *r = map(int, input().split())
        if k == 1:
            x = r[0] - 1
            if not dsu.has_loop[dsu.find(x)]:
                dsu.has_loop[dsu.find(x)] = True
                ans.append(i+1)
        else:
            u, v = r[0]-1, r[1]-1
            if dsu.find(u) != dsu.find(v) and not (dsu.has_loop[dsu.find(u)] and dsu.has_loop[dsu.find(v)]):
                dsu.union(u, v)
                ans.append(i+1)
    
    print(pow(2, len(ans), 10**9+7), len(ans))
    print(*ans)
t = 1

for _ in range(t):
    solve()
