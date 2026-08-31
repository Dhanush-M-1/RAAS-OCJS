from sys import stdin

rInt       = lambda : int(stdin.readline().strip("\n"))
rIntArray  = lambda : [int(x) for x in stdin.readline().split()]

rString    = lambda : stdin.readline().strip("\n")
rStrArray  = lambda : [x for x in stdin.readline().split()]

for _ in range(rInt()):

	n = rInt()

	p, c = [0]*n, [0]*n
	for i in range(n): p[i], c[i] = rIntArray()

	flag = True

	p_count, c_count = 0,0
	for i in range(n):
		if p[i] < p_count or c[i] < c_count or p[i] - p_count < c[i] - c_count:
			flag = False
			break
		p_count, c_count = p[i], c[i]

	print("YES" if flag else "NO")
