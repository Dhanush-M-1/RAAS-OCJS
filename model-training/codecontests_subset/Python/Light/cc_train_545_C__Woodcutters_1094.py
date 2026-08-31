n = int(input())
trees = []
for i in range(n):
	values = input().split(" ")
	trees.append([int(values[0]), int(values[1])])
fallen = 2 if n > 2 else n
for i in range(1, n-1):	
	if ((trees[i][0] - trees[i-1][0] - 1) >= trees[i][1] and (trees[i][0] - trees[i-1][0] - 1) > 0):
		fallen += 1
	elif ((trees[i+1][0] - trees[i][0] - 1) >= trees[i][1] and (trees[i+1][0] - trees[i][0] - 1) > 0):
		fallen += 1
		trees[i][0] += trees[i][1]
print(fallen)