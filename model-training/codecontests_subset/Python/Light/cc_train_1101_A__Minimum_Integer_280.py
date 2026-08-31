for _ in range(int(input())):
	l,r,d=map(int,input().split())
	if d<l:
		print(d)
	else:
		k = r//d
		print((k+1)*d)
