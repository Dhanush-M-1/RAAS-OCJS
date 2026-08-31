test = int(input())
for t in range(test):
	n = int(input())
	grid = []
	for i in range(n):
		grid.append(input())
	if grid[0][1]=='0' and grid[1][0]=='0':
		if grid[n-1][n-2]=='0' and grid[n-2][n-1]=='0':
			print(2)
			print(n, n-1)
			print(n-1, n)
		elif grid[n-1][n-2]=='0' and grid[n-2][n-1]=='1':
			print(1)
			print(n, n-1)
		elif grid[n-1][n-2]=='1' and grid[n-2][n-1]=='0':
			print(1)
			print(n-1, n)
		else:
			print(0)
	elif grid[0][1]=='0' and grid[1][0]=='1':
		if grid[n-1][n-2]=='0' and grid[n-2][n-1]=='0':
			print(1)
			print(1, 2)
		elif grid[n-1][n-2]=='0' and grid[n-2][n-1]=='1':
			print(2)
			print(n, n-1)
			print(2,1)
		elif grid[n-1][n-2]=='1' and grid[n-2][n-1]=='0':
			print(2)
			print(n, n-1)
			print(1,2)
		else:
			print(1)
			print(2,1)
	elif grid[0][1]=='1' and grid[1][0]=='0':
		if grid[n-1][n-2]=='0' and grid[n-2][n-1]=='0':
			print(1)
			print(2, 1)
		elif grid[n-1][n-2]=='0' and grid[n-2][n-1]=='1':
			print(2)
			print(n, n-1)
			print(1,2)
		elif grid[n-1][n-2]=='1' and grid[n-2][n-1]=='0':
			print(2)
			print(n, n-1)
			print(2,1)
		else:
			print(1)
			print(1,2)
	elif grid[0][1]=='1' and grid[1][0]=='1':
		if grid[n-1][n-2]=='0' and grid[n-2][n-1]=='0':
			print(0)
		elif grid[n-1][n-2]=='0' and grid[n-2][n-1]=='1':
			print(1)
			print(n-1, n)
		elif grid[n-1][n-2]=='1' and grid[n-2][n-1]=='0':
			print(1)
			print(n, n-1)
		else:
			print(2)
			print(2,1)
			print(1,2)