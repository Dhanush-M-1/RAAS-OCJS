for i in range(int(input())):
	l, r, d = map(int, input().split())
	ans = d;
	if ans < l :
		print(d)
	else :
		print((r // d + 1) * d)