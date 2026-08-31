trees = [tuple(map(int, input().strip().split())) for _ in range(int(input().strip()))]
n = len(trees)
c = 2
i = 1
while i < n-1:
	if trees[i][0]-trees[i][1] > trees[i-1][0]:
		c += 1
	elif trees[i][0]+trees[i][1] < trees[i+1][0]:
		trees[i] = (trees[i][0]+trees[i][1], 0)
		c += 1
	i += 1
print(min(n, c))