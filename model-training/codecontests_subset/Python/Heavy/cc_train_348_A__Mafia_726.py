'''input
3
1 2 3
'''
from sys import stdin, setrecursionlimit
from collections import defaultdict
import math

setrecursionlimit(15000)


def check(num, arr):
	global s, mx
	if max(mx, math.ceil(s / (len(arr) - 1))) <= num:
		return True
	else:
		return False


# main starts
n = int(stdin.readline().strip())
arr = list(map(int, stdin.readline().split()))
end = sum(arr)
s = end
mx = max(arr)
start = 0
while start <= end:
	if start == end:
		if check(start - 1, arr):
			start -= 1
		else:
			pass
		break

	mid = (start + end) // 2
	if check(mid, arr):
		end = mid - 1
	else:
		start = mid + 1

if check(start, arr):
	print(start)
else:
	print(start + 1)