n = int(input())
tree = []
for i in range(n):
	x,y = map(int, input().split())
	tree.append((x, y))
if n == 1:
	print(1)
elif n == 2:
	print(2)
else:
	tree.sort()
	def bin(tree, mid, n) -> bool:
		count = 0
		end = tree[0][0]
		fallen = []
		for i in range(1, n - 1):
			if mid - count > n - i:
				return False
			if tree[i][0] - tree[i][1] > end:
				count += 1
				end = tree[i][0]
			elif tree[i][0] + tree[i][1] < tree[i + 1][0]:
				count += 1
				end = tree[i][0] + tree[i][1]
			else:
				end = tree[i][0]
		if count >= mid:
			return True
		return False

	ans = 0
	start, end = 0, n - 2
	while start <= end:
		mid = start + (end - start) // 2
		if bin(tree, mid, n):
			ans = mid
			start = mid + 1
		else:
			end = mid - 1
	print(ans + 2) 