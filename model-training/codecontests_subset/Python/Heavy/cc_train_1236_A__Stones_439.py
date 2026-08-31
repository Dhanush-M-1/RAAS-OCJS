t = int(input())

for i in range(t):
	a, b, c = list(map(int, input().split()))

	if b == 0:
		print(0)

	elif (c >= b and b > 0 and c > 1) or (b > c and c > 1):
		if b >= c // 2:
			count = 2 * (c // 2) + c // 2
			b -= c // 2
			c -= 2 * (c // 2)
		else:
			count = b + 2 * b
			c -= 2 * b
			b -= b

		if a > 0 and b > 1:
			if a >= b // 2: 
				count += 2 * (b // 2) + b // 2
			else:
				count += a + 2 * a

		print(count)

	elif b > c and a > 0 and b > 1:
		if a >= b // 2:
			count = 2 * (b // 2) + b // 2
			a -= b // 2
			b -= 2 * (b // 2)
		else:
			count = a + 2 * a
			b -= 2 * a
			a -= a

		if b > 0 and c > 1:
			if b >= c // 2:
				count += 2 * (c // 2) + c // 2
			else:
				count += b + 2 * b

		print(count)

	else:
		print(0)
	