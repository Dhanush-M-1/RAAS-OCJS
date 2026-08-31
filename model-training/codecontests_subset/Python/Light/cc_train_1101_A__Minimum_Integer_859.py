
for i in range(int(input())):
	l,r,d=map(int,input().split())
	if d<l or d>r:
		print(d)
	else:
		print(d*((r//d)+1))		
