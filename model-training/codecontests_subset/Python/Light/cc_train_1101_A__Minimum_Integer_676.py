q = int(input())

for _ in range(q):
	l, r, d = list(map(int, input().split()))

	if(d < l or d > r):
		print(d)

	else:
		div = r//d
		print(d*(div + 1))