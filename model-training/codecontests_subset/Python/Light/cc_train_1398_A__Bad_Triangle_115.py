T = int(input())
for t in range(T):
	n = int(input())
	L = list(map(int, input().split()))
	if L[0] + L[1] <= L[-1]:
		print("1 2 {}".format(n))
	else:
		print(-1)