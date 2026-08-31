for _ in range(int(input())):
	l,r,d = map(int,input().split())
	if d >= l:
		if r%d == 0:
			print(r+d)
		else:
			print(((r//d)+1)*d)
	else:
		print(d)