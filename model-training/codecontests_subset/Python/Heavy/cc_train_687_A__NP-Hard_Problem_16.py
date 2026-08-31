import sys
from math import sqrt, gcd, ceil, log
# from bisect import bisect, bisect_left
from collections import defaultdict, Counter, deque
# from heapq import heapify, heappush, heappop
input = sys.stdin.readline
read = lambda: list(map(int, input().strip().split()))


def main():
	n, m = read()
	adj = [[] for i in range(n+1)]
	for i in range(m):
		u, v = read()
		adj[u].append(v)
		adj[v].append(u)

	color = [0]*(n+1)
	stk = []
	col = {1:2, 2:1}
	ans = [[], [], []]

	for i in range(1, n+1):
		if not color[i] and adj[i]:
			stk = [i]
			color[i] = 1
			ans[1].append(i)
			while stk:
				par = stk.pop()
				for child in adj[par]:
					if color[par] and color[par] == color[child]:
						print(-1); exit()
					if not color[child]:
						color[child] = col[color[par]]
						ans[color[child]].append(child)
						stk.append(child)

	for i in ans[1:]:print(len(i)); print(*i)





if __name__ == "__main__":
	main()