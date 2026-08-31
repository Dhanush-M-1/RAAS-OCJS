from operator import itemgetter
class BIT():#1-indexed
	def __init__(self, size):
		self.table = [0 for _ in range(size+2)]
		self.size = size

	def Sum(self, i):#1からiまでの和
		s = 0
		while i > 0:
			s += self.table[i]
			i -= (i & -i)
		return s

	def PointAdd(self, i, x):#
		while i <= self.size:
			self.table[i] += x
			i += (i & -i)
		return

n = int(input())
x = list(map(int, input().split()))
v = list(map(int, input().split()))
y = sorted([(xx, vv) for xx, vv in zip(x, v)], key=itemgetter(1))
z = [[y[0][0], 1]]
for i in range(1, n):
	if y[i][1] == y[i-1][1]:
		z.append([y[i][0], z[-1][1]])
	else:
		z.append([y[i][0], z[-1][1]+1])
z.sort()
#print(z)
b_sigma, b_num = BIT(n+2), BIT(n+2)
ans = 0
for x, v in z:
	num = b_num.Sum(v)
	ans += x * num - b_sigma.Sum(v)
	b_num.PointAdd(v, 1)
	b_sigma.PointAdd(v, x)
print(ans)