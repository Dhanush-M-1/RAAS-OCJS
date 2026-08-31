q = int(input())
for i in range(q):
	l, r, d = map(int, input().split())
	rd = r//d
	if d<l:
		print(d)
	else:
		print((rd+1)*d)