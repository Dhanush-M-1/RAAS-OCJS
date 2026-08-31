for i in range(int(input())):
	l,r,d=map(int,input().split())
	if d>r or d<l:
		print(d)
	else:
		a=int(r/d)
		print(d*(a+1))
