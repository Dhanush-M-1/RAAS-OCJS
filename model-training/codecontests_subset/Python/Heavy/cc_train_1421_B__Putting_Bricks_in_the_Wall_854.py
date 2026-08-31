for nt in range(int(input())):
	n = int(input())
	grid = []
	for i in range(n):
		grid.append(list(input()))
	if grid[n-1][n-2]==grid[n-2][n-1]:
		count, ans = 0, []
		if grid[n-1][n-2]=="1":
			if grid[0][1]=="1":
				count += 1
				ans.append([1,2])
			if grid[1][0]=="1":
				count += 1
				ans.append([2,1])
		else:
			if grid[0][1]=="0":
				count += 1
				ans.append([1,2])
			if grid[1][0]=="0":
				count += 1
				ans.append([2,1])
		print (count)
		for i in ans:
			print (*i)
	else:
		if grid[n-1][n-2]=="1":
			if grid[0][1]==grid[1][0]:
				if grid[0][1]=="1":
					print (1)
					print (n,n-1)
				else:
					print (1)
					print (n-1,n)
			else:
				if grid[0][1]=="1":
					print (2)
					print (1,2)
					print (n-1,n)
				else:
					print (2)
					print (1,2)
					print (n,n-1)
		else:
			if grid[0][1]==grid[1][0]:
				if grid[0][1]=="1":
					print (1)
					print (n-1,n)
				else:
					print (1)
					print (n,n-1)
			else:
				if grid[0][1]=="1":
					print (2)
					print (1,2)
					print (n,n-1)
				else:
					print (2)
					print (1,2)
					print (n-1,n)










