t = int(input())
for _ in range(t):
	n = int(input())
	arr = []
	for i in range(n):
		arr += [input()]

	a, b = int(arr[0][1]), int(arr[1][0])
	x, y = int(arr[-1][-2]), int(arr[-2][-1])

	ans = []

	if x == 0 and y == 0:
		if a == 0:
			ans += [[1, 2]]
		if b == 0:
			ans += [[2, 1]]

	elif x == 1 and y == 1:
		if a == 1:
			ans += [[1, 2]]
		if b == 1:
			ans += [[2, 1]]

	elif a == 0 and b == 0:
		if x == 0:
			ans += [[n, n-1]]
		if y == 0:
			ans += [[n-1, n]]

	elif a == 1 and b == 1:
		if x == 1:
			ans += [[n, n-1]]
		if y == 1:
			ans += [[n-1, n]]
			
	else:
		#top left is 0, 0
		if a == 0:
			ans += [[2, 1]]
		else:
			ans += [[1, 2]]

		#bottom right is 1, 1
		if x == 0:
			ans += [[n, n-1]]
		if y == 0:
			ans += [[n-1, n]]

	print(len(ans))
	for x in ans:
		print(*x)



