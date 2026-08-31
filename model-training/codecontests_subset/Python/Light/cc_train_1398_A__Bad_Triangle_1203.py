for _ in range(int(input())):
	length = int(input())
	if length < 3:
		print(-1); continue

	sequence = [int(i) for i in input().split()]
	min_side = sequence[0]; max_side = sequence[-1]
	if sequence[1] <= max_side - min_side:
		print(1, 2, length)
	else:
		print(-1)