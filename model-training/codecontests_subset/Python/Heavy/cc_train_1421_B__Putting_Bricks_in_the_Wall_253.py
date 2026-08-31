import queue

t = int(input())

while (t):

	n = int(input())

	grid = []
	for i in range(n):
		grid.append(input())

	ans = []

	if (grid[0][1] == grid[1][0]):
		if (grid[-1][-2] == grid[0][1]):
			ans.append((n,n-1))
		if (grid[-2][-1] == grid[0][1]):
			ans.append((n-1,n))

	elif (grid[-1][-2] == grid[-2][-1]):
		if (grid[0][1] == grid[-1][-2]):
			ans.append((1,2))
		if (grid[1][0] == grid[-1][-2]):
			ans.append((2,1))

	else:
		if (grid[0][1] != grid[-1][-2]):
			ans = [(1,2),(n,n-1)]
		elif (grid[0][1] != grid[-2][-1]):
			ans = [(1,2),(n-1,n)]
		elif (grid[1][0] != grid[-1][-2]):
			ans = [(2,1),(n,n-1)]
		else: 
			ans = [(2,1),(n-1,n)]

	print(len(ans))
	for a in ans:
		print(a[0],a[1])

	t -= 1
			
	
	