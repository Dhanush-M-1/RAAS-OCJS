for i in range(int(input())):
	l , r , d = map(int,input().split())
	if d<l:
		print(d)
	else:
		a = r//d
		print((a+1)*d)	
