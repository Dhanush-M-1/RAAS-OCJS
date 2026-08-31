def solve(n, trees, heights):

	state = {tree: [] for tree in trees}

	tree0 = trees[0]
	height0 = heights[0]
	state[trees[0]] = [1, 1, tree0]

	for i in range(1, n):
		tree = trees[i]
		height = heights[i]

		if trees[i] - heights[i] > trees[i - 1] + heights[i - 1]:
			maxLeft = max(state[trees[i - 1]][:2]) + 1
		elif trees[i] - heights[i] > trees[i - 1]:
			maxLeft = state[trees[i - 1]][0] + 1
		else:
			maxLeft = max(state[trees[i - 1]][:2])

		fallToRightable = ableToFallRight(i, n, trees, heights)
		
		maxRight = max(state[trees[i - 1]][:2]) + fallToRightable

		if fallToRightable == 1:
			lengthRight = tree + height
		else:
			lengthRight = tree

		state[tree] = [maxLeft, maxRight, lengthRight]

	return max(state[trees[-1]][:2])


def ableToFallRight(index, n, trees, heights):

	if index == n - 1:
		return 1

	if trees[index] + heights[index] >= trees[index + 1]:
		return 0
	return 1


def run():

	n = int(input())

	trees = []
	heights = []

	for i in range(n):
		inputString = input()
		inputs = inputString.split()
		trees.append(int(inputs[0]))
		heights.append(int(inputs[1]))

	print(solve(n, trees, heights))

run()