from bisect import *

for _ in range(int(input())):
	n = int(input())
	A = list(map(int, input().split()))

	a = A[0] + A[1]
	if a <= A[-1]:
		print(1, 2, n)
	else:
		print(-1)
