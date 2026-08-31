import sys
from math import sqrt, gcd, ceil, log, floor
from bisect import bisect, bisect_left
from collections import defaultdict, Counter, deque
from heapq import heapify, heappush, heappop
input = sys.stdin.readline
read = lambda: list(map(int, input().strip().split()))

# sys.setrecursionlimit(200000)
# MOD = 10**9 + 7
def main():
	# ans_ = []
	for _ in range(int(input())):
		n = int(input()); arr = read()
		if arr[0]+arr[1] <= arr[-1]:
			print(1, 2, n)
		else:
			print(-1)
	# 	ans_.append(str(ans))
	# print(("\n").join(ans_))
if __name__ == "__main__":
	main()