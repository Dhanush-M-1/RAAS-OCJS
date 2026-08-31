import math
t = int(input())

for _ in range(t):
	n = int(input())
	grid = []
	for i in range(n):
		grid.append(list(input()))
	
	cnt1 = 0
	ans1 = []
	
	cnt2 = 0
	ans2 = []
	
	for i in range(3):
		if grid[n-1-i][n-3+i]!='0':
			cnt1 += 1
			ans1.append((n-i,n-2+i))
	for i in range(2):
		if grid[n-1-i][n-2+i]!='1':
			cnt1 += 1
			ans1.append((n-i,n-1+i))		
			
	for i in range(3):
		if grid[n-1-i][n-3+i]!='1':
			cnt2 += 1
			ans2.append((n-i,n-2+i))
	for i in range(2):
		if grid[n-1-i][n-2+i]!='0':
			cnt2 += 1
			ans2.append((n-i,n-1+i))		
	
		
	if cnt1 <=2:
		print(cnt1)
		for i in range(cnt1):
			print(ans1[i][0],ans1[i][1])
	else:
		print(cnt2)
		for i in range(cnt2):
			
			print(ans2[i][0],ans2[i][1])
		
	
