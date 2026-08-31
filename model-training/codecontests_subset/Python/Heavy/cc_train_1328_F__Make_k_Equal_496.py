'''input
5 3
1 2 3 3 3
'''
from sys import stdin
from copy import deepcopy
from collections import deque


def solve(aux):
	# print(aux)

	count = 0
	for i in range(1, len(aux)):
		while  True:
			if aux[i] > aux[i - 1]:
				aux[i] //= 2
				count += 1
			elif aux[i] < aux[i - 1]:
				aux[i - 1] //= 2
				count += i
			else:
				break
	
	# print(count)
	return count


def get_arr(num, arr):
	aux = []
	for i in range(len(arr)):
		count = 0
		c = arr[i]
		while True:
			if c > num:
				c//= 2
				count += 1
			elif c < num:
				aux.append(float('inf'))
				break
			else:
				aux.append(count)
				break
	aux.sort()
	# print(num, aux)
	return aux


# main starts
n, k = list(map(int, stdin.readline().split()))
arr = list(map(int, stdin.readline().split()))
m = max(arr)
ans = float('inf')
for i in range(0, m + 1):
	aux = get_arr(i, arr)
	ans = min(ans, sum(aux[: k]))

print(ans)