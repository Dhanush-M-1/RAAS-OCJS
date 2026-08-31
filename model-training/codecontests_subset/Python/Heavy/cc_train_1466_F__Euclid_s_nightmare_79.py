class UnionFindVerSize():
    def __init__(self, N):
        self._parent = [n for n in range(0, N)]
        self._size = [1] * N
        self.source = [False] * N
        self.group = N

    def find_root(self, x):
        if self._parent[x] == x: return x
        self._parent[x] = self.find_root(self._parent[x])
        stack = [x]
        while self._parent[stack[-1]]!=stack[-1]:
            stack.append(self._parent[stack[-1]])
        for v in stack:
            self._parent[v] = stack[-1]
        return self._parent[x]

    def unite(self, x, y):
        gx = self.find_root(x)
        gy = self.find_root(y)
        if gx == gy: return

        self.group -= 1

        if self._size[gx] < self._size[gy]:
            self._parent[gx] = gy
            self._size[gy] += self._size[gx]
            self.source[gy] |= self.source[gx]
        else:
            self._parent[gy] = gx
            self._size[gx] += self._size[gy]
            self.source[gx] |= self.source[gy]

    def add_size(self,x):
        self.source[self.find_root(x)] = True

    def get_size(self, x):
        return self._size[self.find_root(x)]

    def get_source(self,x):
        return self.source[self.find_root(x)]

    def is_same_group(self, x, y):
        return self.find_root(x) == self.find_root(y)

import sys

input = sys.stdin.buffer.readline

m,n = map(int,input().split())

uf = UnionFindVerSize(n)

S = []
source = []
for i in range(m):
    edge = tuple(map(int,input().split()))
    if edge[0]==1:
        v = edge[1]
        if not uf.get_source(v-1):
            uf.add_size(v-1)
            S.append(i+1)
    else:
        u,v = edge[1],edge[2]
        if not uf.is_same_group(u-1,v-1) and (not uf.get_source(u-1) or not uf.get_source(v-1)):
            uf.unite(u-1,v-1)
            S.append(i+1)

ans = 1
k = 0
mod = 10**9 + 7
for i in range(n):
    if uf.find_root(i)==i:
        if uf.get_source(i):
            k += uf.get_size(i)
        else:
            k += uf.get_size(i) - 1

print(pow(2,k,mod),len(S))
S.sort()
print(*S)
