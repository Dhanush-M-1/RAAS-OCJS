q = int(input())
while(q):
	q -= 1
	l, r, d = [int(x) for x in input().split()]
	if l > d:
		print(d)
	else:
		print(((r // d) + 1) * d)