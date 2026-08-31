import sys,math,itertools
from collections import Counter,deque,defaultdict
from bisect import bisect_left,bisect_right 
from heapq import heappop,heappush,heapify, nlargest
from copy import deepcopy,copy
mod = 10**9+7
INF = float('inf')
def inp(): return int(sys.stdin.readline())
def inpl(): return list(map(int, sys.stdin.readline().split()))
def inpl_1(): return list(map(lambda x:int(x)-1, sys.stdin.readline().split()))
def inps(): return sys.stdin.readline()
def inpsl(x): tmp = sys.stdin.readline(); return list(tmp[:x])
def err(x): print(x); exit()

class UnionFind():
    def __init__(self, n):
        self.n = n
        self.parents = [-1] * n

    def find(self, x):
        if self.parents[x] < 0:
            return x
        else:
            self.parents[x] = self.find(self.parents[x])
            return self.parents[x]

    def union(self, x, y):
        x = self.find(x)
        y = self.find(y)

        if x == y:
            return

        if self.parents[x] > self.parents[y]:
            x, y = y, x

        self.parents[x] += self.parents[y]
        self.parents[y] = x

    def size(self, x):
        return -self.parents[self.find(x)]

    def same(self, x, y):
        return self.find(x) == self.find(y)

    def members(self, x):
        root = self.find(x)
        return [i for i in range(self.n) if self.find(i) == root]
        
    def roots(self):
        return [i for i, x in enumerate(self.parents) if x < 0]

    def group_count(self):
        return len(self.roots())
n,m = inpl()
un = [set() for _ in range(n)]
for _ in range(m):
    a,b = inpl_1()
    un[b].add(a); un[a].add(b)
uf = UnionFind(n)
seen = [0]*n
unknown = set(range(n))
for i in range(n):
    if seen[i]: continue
    seen[i] = 1
    unknown.discard(i)
    adj = deque()
    noadj = set()
    for j in unknown:
        if not j in un[i]: adj.append(j)
        else: noadj.add(j)
    while adj:
        j = adj.popleft()
        for k in noadj - un[j]:
            adj.append(k)
            noadj.discard(k)
        seen[j] = 1
        unknown.discard(j)
        uf.union(i,j)
res = []
for root in uf.roots():
    res.append(uf.size(root))
res.sort()
print(len(res))
print(*res)