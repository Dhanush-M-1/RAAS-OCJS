def possible():
	n_trees = 2
	left = True
	for i in range(1, n - 1):
		x, h = trees[i]
		if left == True:
			if x - h > trees[i - 1][0]:
				n_trees += 1
			elif x + h < trees[i + 1][0]:
				n_trees += 1
				left = False
			else:
				left = True
		else:
			if x - h > sum(trees[i - 1]):
				left = True
				n_trees += 1
			elif x + h < trees[i + 1][0]:
				n_trees += 1
			else:
				left = True
	return n_trees


n = int(input())
trees = []
for i in range(n):
	x, h = map(int, input().split())
	trees.append((x, h))
if n < 3:
	print(n)
else:
	print(possible())