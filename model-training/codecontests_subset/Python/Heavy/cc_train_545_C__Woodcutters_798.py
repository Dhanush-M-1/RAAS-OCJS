# http://codeforces.com/contest/545/problem/C

n = int(input())
trees = []
# trees = [(int(x), int(h)) for (x, h) in input().split()]
for i in range(n):
	tree = [int(n) for n in input().split()]
	trees.append(tree)


# print(trees)/
left = trees[0][0]
cutted=1

for i, (x, h) in enumerate(trees[1:-1]):
	# print(x, h)
	if x - left > h:
		# print("cutting to left")
		cutted += 1
		left = x
	elif trees[i+2][0] - x > h:
		# print("cutting to right")
		cutted += 1
		left = x + h

	else:
		# print("not cutting")
		left = x

# print(cutted)
print(cutted + 1) if len(trees) > 1 else print(cutted)

# [(1,1),(2,5),(8,2)]