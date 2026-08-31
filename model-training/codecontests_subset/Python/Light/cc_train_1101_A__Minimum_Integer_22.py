from sys import stdin
q = int(stdin.readline())

for i in range(q):
	R = lambda: map(int, stdin.readline().split())
	l, r, d = R()
	small = (l-1) // d
	large = r // d

	if small * d < l and small * d > 0:
		print(d)
	else:
		print((large + 1) * d)