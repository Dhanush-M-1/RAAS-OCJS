for _ in range(int(input())):
	N=int(input())
	grid=[]
	for i in range(N):
		grid.append(list(input()))
	if grid[1][0]==grid[0][1] and grid[N-2][N-1]==grid[N-1][N-2] and grid[1][0]!=grid[N-2][N-1]:
		print(0)
	elif grid[1][0]==grid[0][1] and grid[N-2][N-1]==grid[N-1][N-2] and grid[1][0]==grid[N-2][N-1]:
		print(2)
		print(1,2)
		print(2,1)
	elif grid[1][0]!=grid[0][1] and grid[N-2][N-1]!=grid[N-1][N-2]:
		if grid[1][0]==grid[N-2][N-1]:
			print(2)
			print(2,1)
			print(N,N-1)
		else:
			print(2)
			print(2,1)
			print(N-1,N)
	else:
		print(1)
		tobechecked=[grid[1][0],grid[0][1],grid[N-2][N-1],grid[N-1][N-2]]
		frequency={}
		for i in tobechecked:
			if i in frequency:
				frequency[i]+=1
			else:
				frequency[i]=1
		for i in frequency:
			if frequency[i]==1:
				death=i
		for i in range(4):
			if tobechecked[i]==death:
				if i==0:
					print(1,2)
				elif i==1:
					print(2,1)
				elif i==2:
					print(N,N-1)
				else:
					print(N-1,N)