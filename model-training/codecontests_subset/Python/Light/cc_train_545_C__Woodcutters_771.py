n = eval(input())

res = 1


tree_pairs = [[0], 0, 0]

if n > 0:
	tree_pairs[0] = ([int(i) for i in input().split()])

if n > 1:
	tree_pairs[1] = ([int(i) for i in input().split()])

if n > 2:
	for i in range(1, n-1):
		tree_pairs[2] = ([int(i) for i in input().split()])

		if (tree_pairs[1][0] - tree_pairs[1][1]) > tree_pairs[0][0]:
			res += 1
		elif (tree_pairs[1][0] + tree_pairs[1][1]) < tree_pairs[2][0]:
			tree_pairs[1][0] += tree_pairs[1][1]
			res += 1

		tree_pairs[0] = tree_pairs[1]
		tree_pairs[1] = tree_pairs[2]

	res += 1

	print(res)
elif n == 1:
	print(1)
elif n == 2:
	print(2)
else:
	print(0)



	

