t = int(input())

xs = []
pref = []
n = 0

class SegmentTree:
	def __init__(self, n):
		self.t = [0 for _ in range(n * 4)]
	
	def Build(self, v, tl, tr):
		if tl + 1 == tr:
			self.t[v] = pref[tl]
		else:
			tm = (tl + tr) >> 1
			self.Build(v * 2 + 1, tl, tm)
			self.Build(v * 2 + 2, tm, tr)
			self.t[v] = max(self.t[v * 2 + 1], self.t[v * 2 + 2]) 
	
	def Get(self, v, tl, tr, l, r, val):
		if tl >= r or tr <= l or self.t[v] < val:
			return -1
		if tl + 1 == tr:
			return tl
		else:
			tm = (tl + tr) >> 1
			res = self.Get(v * 2 + 1, tl, tm, l, r, val)
			if res == -1:
				return self.Get(v * 2 + 2, tm, tr, l, r, val)
			return res

tree = SegmentTree(0)

def FindPos(val):
	return tree.Get(0, 0, n, 0, n, val)
	
for _ in range(t):
	n, m = list(map(int ,input().split()))
	a = list(map(int,input().split()))
	xs = list(map(int,input().split()))
	pref = [a[i] for i in range(n)]
	for i in range(1, n):
		pref[i] += pref[i - 1]

	tree = SegmentTree(n)
	tree.Build(0, 0, n)
	dlt = pref[-1]
	INF = 5 * 10 ** 9
	if dlt <= 0:
		for x in xs:
			pos = FindPos(x)
			print(pos, end = ' ')
		print()
	else:
		mx = max(pref)
		for x in xs:
			k = max(0, (x - mx + dlt - 1) // dlt)
			ans = k * n
			x -= k * dlt
			ans += FindPos(x)
			
			print(ans, end = ' ')
		print()
