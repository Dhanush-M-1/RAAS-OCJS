from sys import stdin

class DSU:
    def __init__(self, n) -> None:
        self.parent = [i for i in range(n)]
        self.rank =[0]*n

    def find_set(self, v):
        w = v
        parent = self.parent
        while parent[v] != v:
            v = parent[v]
        while parent[w] != w:
            t = parent[w]
            parent[w] = v
            w = t
        return v

    def union_sets(self, a, b):
        a = self.find_set(a)
        b = self.find_set(b)
        rank = self.rank
        if a != b:
            if rank[a] < rank[b]:
                rank[a], rank[b] = rank[b], rank[a]
            self.parent[b] = a
            if rank[a] == rank[b]:
                rank[a] += 1


n,m,q=map(int,stdin.readline().split())
dsu=DSU(n+m)
for i in range(q):
    r,c = map(int, stdin.readline().split())
    r-=1
    c-=1
    dsu.union_sets(r, c+n)
ans = -1
for i in range(n+m):
    if dsu.parent[i] == i:
        ans += 1
print(ans)