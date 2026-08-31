
import sys
from collections import deque, defaultdict
import copy
import bisect
#sys.setrecursionlimit(10 ** 9)
import math
import heapq
from itertools import combinations, permutations

import sys
def input():
	return sys.stdin.readline().strip()


N, M = list(map(int, input().split()))
default = 100000000000000000000000

graph = [[] for _ in range(N)]
dist = [default for _ in range(N)]

for i in range(M):
	L, R, D = list(map(int, input().split()))
	L -= 1
	R -= 1
	graph[L].append([R, D])
	graph[R].append([L, -D])

loc = 0
while loc < N:
	if dist[loc] == default:
		dist[loc] = 0
		que = deque([])
		que.append(loc)
		while len(que) > 0:
			node = que.popleft()
			if len(graph[node]) > 0:
				for edge in graph[node]:
					if dist[edge[0]] == default:
						dist[edge[0]] = dist[node] + edge[1]
						que.append(edge[0])
					elif dist[edge[0]] != dist[node] + edge[1]:
						print("No")
						exit()
	loc += 1
print("Yes")