import sys
input=sys.stdin.readline
from collections import defaultdict
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
    def all_group_members(self):
        group_members = defaultdict(list)
        for member in range(self.n):
            group_members[self.find(member)].append(member)
        return group_members
n=int(input())
can_del=[]
uf=UnionFind(n)
for _ in range(n-1):
    u,v=map(int,input().split())
    u-=1;v-=1
    if uf.same(u,v):
        can_del.append([u+1,v+1])
    else:
        uf.union(u,v)
need_add=[]
for i in range(n):
    for j in range(i+1,n):
        if not uf.same(i,j):
            need_add.append([i+1,j+1])
            uf.union(i,j)
print(len(can_del))
for i in range(len(can_del)):
    print(*can_del[i],*need_add[i])