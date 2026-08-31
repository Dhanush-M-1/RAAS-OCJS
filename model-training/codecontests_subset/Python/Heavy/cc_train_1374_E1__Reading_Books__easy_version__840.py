import sys
input = sys.stdin.readline

INF = 10 ** 18
n, m, k = map(int, input().split())
B = [tuple(map(int, input().split())) for _ in range(n)]

GB = []
AB = []
BB = []
RB = []

for i, (t, a, b) in enumerate(B):
	if a and b:
		GB.append((t, i))
	elif a:
		AB.append((t, i))
	elif b:
		BB.append((t, i))
	else:
		RB.append((t, i))

GB.sort()
AB.sort()
BB.sort()

# TODO: already sorted
CB = sorted((t1+t2, i1, i2) for (t1, i1), (t2, i2) in zip(AB, BB))

N = 1
while N <= 10 ** 4: N *= 2

T = [(0, 0)] * (2 * N)
def comb(a, b):
	return (a[0] + b[0], a[1] + b[1])

def add_book(t, inc=1):
	i = t + N
	T[i] = comb(T[i], (t*inc, inc))
	while i > 1:
		i //= 2
		T[i] = comb(T[i*2], T[i*2+1])

def query(x):
	assert x >= 0
	s = 0
	i = 1
	while x:
		ts, tc = T[i]
		if tc < x: return INF
		elif tc == x:
			s += ts
			break

		if i >= N:
			s += ts // tc * x
			break

		i *= 2
		if T[i][1] < x:
			s += T[i][0]
			x -= T[i][1]
			i += 1
	return s

for t, _ in RB: add_book(t)
for t, _ in AB: add_book(t)
for t, _ in BB: add_book(t)

gb_i = 0
gb_t = 0
while gb_i < min(len(GB), m):
	gb_t += GB[gb_i][0]
	gb_i += 1

for t, _ in GB[gb_i:]: add_book(t)

cb_i = 0
cb_t = 0
while gb_i + cb_i < k and gb_i + 2 * (cb_i + 1) <= m and cb_i < len(CB):
	cb_t += CB[cb_i][0]

	add_book(AB[cb_i][0], -1)
	add_book(BB[cb_i][0], -1)
	cb_i += 1

if gb_i + cb_i < k:
	print(-1)
	sys.exit()

best = (INF, -1, -1)
while True:
	best = min(best, (gb_t + cb_t + query(m - 2 * cb_i - gb_i), gb_i, cb_i))

	if not gb_i: break

	gb_i -= 1
	gb_t -= GB[gb_i][0]
	add_book(GB[gb_i][0])

	if gb_i + cb_i < k:
		if cb_i == len(CB): break

		cb_t += CB[cb_i][0]
		add_book(AB[cb_i][0], -1)
		add_book(BB[cb_i][0], -1)
		cb_i += 1

		if gb_i + 2 * cb_i > m: break
		"""
		if not gb_i: break

		gb_i -= 1
		gb_t -= GB[gb_i][0]
		add_book(GB[gb_i][0])
		"""

bs, bi, bj = best
assert bs != INF

ans = []
comps = 0
for t, i in GB[:bi]:
	ans.append(i+1)
	comps += t

for t, i1, i2 in CB[:bj]:
	ans.append(i1+1)
	ans.append(i2+1)
	comps += t

if bi + 2 * bj < m:
	rem = GB[bi:] + AB[bj:] + BB[bj:] + RB
	rem.sort()
	for t, i in rem[:m - bi - 2 * bj]:
		ans.append(i+1)
		comps += t

assert comps == bs
print(bs)
print(*ans)
