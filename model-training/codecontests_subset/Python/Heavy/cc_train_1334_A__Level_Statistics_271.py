import sys
from math import sqrt, floor
# from bisect import bisect
from collections import deque, Counter
inp = sys.stdin.readline
read = lambda: list(map(int, inp().split()))



def a():
	ans = ""
	for _ in range(int(inp())):
		n = int(inp()); last = [0, 0]; flag = 1
		for i in range(n):
			arr = read()
			# print(last, arr)
			if arr[0] < last[0]:flag = 0
			if arr[1] < last[1]:flag = 0
			if arr[0] < arr[1]:flag = 0
			if arr[0]-last[0] < arr[1] - last[1]: flag = 0
			last = arr
		ans += "YNEOS"[not flag::2]+"\n"
	print(ans)


if __name__ == "__main__":
	a()
	# b()
	# c()
	# d()

