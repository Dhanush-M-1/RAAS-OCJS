import sys
input = sys.stdin.readline
N, M = map(int, input().split())
mod = 10 ** 9 + 7

base = [0] * (M + 1)
e = [[] for _ in range(M + 1)]
res = []

class UnionFind():
  def __init__(self, n):
    self.n = n
    self.root = [-1] * (n + 1)
    self.rnk = [0] * (n + 1)

  def Find_Root(self, x):
    if self.root[x] < 0:
      return x
    else:
      self.root[x] = self.Find_Root(self.root[x])
      return self.root[x]

  def Unite(self, x, y):
    x = self.Find_Root(x)
    y = self.Find_Root(y)
    if x == y:
      return 
    elif self.rnk[x] > self.rnk[y]:
      self.root[x] += self.root[y]
      self.root[y] = x
    else:
      self.root[y] += self.root[x]
      self.root[x] = y
      if self.rnk[x] == self.rnk[y]:
        self.rnk[y] += 1

  def isSameGroup(self, x, y):
    return self.Find_Root(x) == self.Find_Root(y)

  def Count(self, x):
    return -self.root[self.Find_Root(x)]

uf = UnionFind(M)

for i in range(1, N + 1):
  a = list(map(int, input().split()))
  if a[0] == 1: a.append(0)
  u, v = a[1: ]
  if uf.isSameGroup(u, v): continue
  else:
    uf.Unite(u, v)
    res.append(i)
  
print(pow(2, len(res), mod), len(res))
print(*res)