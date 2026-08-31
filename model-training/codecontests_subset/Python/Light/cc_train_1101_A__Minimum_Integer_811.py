Q = int(input())
for i in range(Q):
	l, r, d = map(int, input().split())
	ans = d;
	if ans >= l:
		ans = (r // d + 1) * d
	print(ans)
