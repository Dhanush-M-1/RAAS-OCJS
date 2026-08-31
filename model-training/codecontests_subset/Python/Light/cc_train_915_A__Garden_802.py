from collections import deque

n, k = str(input()).split()
n, k = int(n), int(k)

values = list(map(float, input().split()))
values.sort()
values.reverse()

for value in values:
	if k % value == 0:
		print(int(k / value))
		break
