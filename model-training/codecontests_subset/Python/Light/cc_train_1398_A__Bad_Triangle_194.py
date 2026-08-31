from random import randint

t = int(input())
for _ in range(t):
	n = int(input())
	arr = [int(j) for j in input().split()]
	if arr[0] + arr[1] <= arr[-1]:
		print(1, 2, n)
	else:
		print(-1)


		