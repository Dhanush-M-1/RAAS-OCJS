for _ in range(int(input())):
	f=0
	l,r,d=map(int,input().split())
	if l>d:
		print(d)
	else:
		if d>r:
			print(d)
		else:
			print(r+d-r%d if r%d!=0 else r+d)
