t = int(input())
for _ in range(t):
	n = int(input())
	grid = []
	for i in range(n):
		grid.append(input())
	count = 0
	ans = ""
	if(grid[-1][-2] == grid[-2][-1]):
		if(grid[0][1] == grid[-2][-1]):
			ans += "\n1 2"
			count+=1
		if(grid[1][0] == grid[-2][-1]):
			ans += "\n2 1"
			count+=1

	elif(grid[0][1] == grid[1][0]):
		if(grid[-1][-2] == grid[0][1]):
			count += 1
			ans +="\n"+str(n)+" " + str(len(grid[0])-1)
		if(grid[-2][-1] == grid[0][1]):
			count +=1
			ans += "\n"+str(n-1)+" " + str(len(grid[0]))

	elif(grid[0][1] != grid[-1][-2]):
		count+=2
		ans += "\n1 2"
		ans += "\n"+str(n)+" " + str(len(grid[0])-1)
	elif(grid[0][1] != grid[-2][-1]):
		count+=2
		ans += "\n1 2"
		ans += "\n"+str(n-1)+" " + str(len(grid[0]))
	print(str(count)+ans)
