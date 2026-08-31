class DSU:
    def __init__(self, N):
        self.sz     = [1] * N
        self.parent = list(range(N))
        self.redundant = []

    def find(self, node):
        if node == self.parent[node]:
            return node
        self.parent[node] = self.find(self.parent[node])
        return self.parent[node]

    def union(self, a, b):
        p1,p2 = self.find(a), self.find(b)
        if p1 == p2:
            self.redundant.append((a,b))
        else:
            if self.sz[p1] < self.sz[p2]:
                self.parent[p1] = p2
                self.sz[p2] += self.sz[p1]
            else:
                self.parent[p2] = p1
                self.sz[p1] += self.sz[p2]

N = int(input())
dsu = DSU(N)
for _ in range(N-1):
    a,b = map(int, input().split())
    a -= 1
    b -= 1
    dsu.union(a,b)
s = set()
for i in range(N):
    s.add(dsu.find(i))
s = list(s)
print(len(s) - 1)
for x,y in zip(s, s[1:]):
    a,b = dsu.redundant.pop()
    print("{} {} {} {}".format(a+1, b+1, x+1, y+1))

