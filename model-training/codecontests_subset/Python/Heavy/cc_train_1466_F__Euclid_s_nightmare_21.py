import sys
def input():
	return sys.stdin.buffer.readline()[:-1]

class UnionFind():
	def __init__(self, size):
		self.table = [-1 for _ in range(size)]

	def find(self, x):
		while self.table[x] >= 0:
			if self.table[self.table[x]] >= 0:
				self.table[x] = self.table[self.table[x]]
			x = self.table[x]
		return x

	def same(self, x, y):
		return self.find(x) == self.find(y)

	def unite(self, x, y):
		s1 = self.find(x)
		s2 = self.find(y)
		if s1 != s2:
			r1 = self.table[s1]
			r2 = self.table[s2]
			if r1 <= r2:
				self.table[s2] = s1
				if r1 == r2:
					self.table[s1] -= 1
			else:
				self.table[s1] = s2
		return

m, n = map(int, input().split())
uf = UnionFind(n+1)
ans = []
for i in range(1, m+1):
	q = list(map(int, input().split()))
	if q[0] == 1:
		if uf.same(q[1]-1, n):
			continue
		else:
			ans.append(i)
			uf.unite(q[1]-1, n)
	else:
		if uf.same(q[1]-1, q[2]-1):
			continue
		else:
			ans.append(i)
			uf.unite(q[1]-1, q[2]-1)
print(pow(2, len(ans), 10**9+7), len(ans))
print(*ans)