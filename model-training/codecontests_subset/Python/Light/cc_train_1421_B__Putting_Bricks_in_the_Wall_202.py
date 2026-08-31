t=int(input())
for _ in range(t):
	n=int(input())
	grid=[]
	for i in range(n):
		l=input()
		grid.append(l)
	a=grid[0][1]
	b=grid[1][0]
	c=grid[n-2][n-1]
	d=grid[n-1][n-2]

	if a==b:
		if c==d:
			if a==c:
				print("2")
				print(n,n-1)
				print(n-1,n)
			else:
				print("0")
		else:
			print("1")
			if a==c:
				print(n-1,n)
			else:
				print(n,n-1)
	else:
		if c==d:
			print("1")
			if a==c:
				print("1 2")
			else:
				print("2 1")
		else:
			print("2")
			if a==c:
				print("2 1")
				print(n-1,n)
			else:
				print("2 1")
				print(n,n-1)