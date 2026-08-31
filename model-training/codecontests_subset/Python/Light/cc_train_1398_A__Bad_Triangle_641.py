t = int(input())

for i in range(t):
	n = int(input())
	A = list(map(int, input().split()))
	if A[0] + A[1] <= A[-1]:
		print("1 2 {}".format(n))
	else:
		print(-1)