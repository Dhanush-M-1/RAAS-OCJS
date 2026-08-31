#codeforces_1101A
gi = lambda : list(map(int,input().split()))
for k in range(gi()[0]):
	l,r,d = gi()
	if l <= d <= r:
		ans = (r//d)*d
		if r%d or (r//d)*d == r: ans += d
	else:
		ans = d
	print(ans)