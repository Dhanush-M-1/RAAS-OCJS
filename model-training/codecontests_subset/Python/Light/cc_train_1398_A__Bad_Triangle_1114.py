t = int(input())
for _ in range(t):
	n = int(input())
	ls = list(map(int, input().split()))
	if ls[0] + ls[1] <= ls[-1]:
		print(1, 2, n)
	else:
		print(-1)