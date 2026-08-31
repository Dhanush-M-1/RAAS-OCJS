#!/usr/bin/env python3

n = int(input())

class UnionFind:
  def __init__(self, n):
    self.representative = [i for i in range(n)]
  def find(self, a):
    r = self.representative[a]
    if (self.representative[r] != r):
      r = self.find(r)
      self.representative[a] = r
    return r
  def union(self, a, b):
    ra = self.find(a)
    rb = self.find(b)
    self.representative[ra] = rb
  def same(self, a, b):
    return self.find(a) == self.find(b)

uf = UnionFind(n)
edges_to_remove = []
for i in range(n-1):
  (a,b) = map(int, input().split())
  a , b = a-1, b-1
  if uf.same(a,b):
    edges_to_remove.append((a,b))
  else:
    uf.union(a,b)

edges_to_create = []
for i in range(n):
  if not uf.same(0,i):
    edges_to_create.append((0,i))
    uf.union(0,i)

output = []
for ((i,j),(u,v)) in zip(edges_to_remove, edges_to_create):
  output.append("%d %d %d %d" % (i+1, j+1, u+1, v+1))
output = ["%d" % len(output)] + output
print("\n".join(output))
