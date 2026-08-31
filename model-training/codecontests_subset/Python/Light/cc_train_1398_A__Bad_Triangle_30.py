def solve():
	nb = int(input())
	l = list(map(int, input().split()))

	c = True
	
	imi1, mi1 = l.index(min(l))+1, min(l)
	l.remove(min(l))
	imi2, mi2 = l.index(min(l))+2, min(l)
	l.remove(min(l))
	if max(l) >= mi1 + mi2:
		res = [imi1, imi2, l.index(max(l))+3]
		res.sort()
		print(res[0], res[1], res[2])
		c = False
	if c:
		print(-1)

n = int(input())
for _ in range(n):
	solve()