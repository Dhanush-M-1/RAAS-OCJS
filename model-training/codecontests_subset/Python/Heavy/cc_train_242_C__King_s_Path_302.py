from collections import *
import bisect
import heapq
import sys
from math import inf

def ri():
    return int(input())
 
def rl():
    return list(map(int, input().split()))

def isPossiblePlace(x, y):
	for my_list in allowed[x]:
		a, b  = my_list
		if y >= a and y <= b:
			return True
	return False

def bfs(x0, y0, x1, y1):
	visited = defaultdict(list)
	to_visit = deque()
	to_visit.append((x0, y0, 0))
	visited[x0].append(y0)
	while to_visit:
		x,y,d = to_visit.popleft()
		for dx in [-1,0,1]:
			for dy in [-1,0,1]:
				if abs(dx) + abs(dy) != 0:
					nx = x + dx
					ny = y + dy
				if nx >= 1 and nx <= 10**9 and ny >= 1 and ny <= 10**9:
					if isPossiblePlace(nx, ny):
						if (nx, ny) == (x1,y1):
							return d + 1
						if ny not in visited[nx]:
							visited[nx].append(ny)
							to_visit.append((nx, ny, d + 1))

	return -1

							



x0, y0, x1, y1 = rl()
n = ri()

allowed = defaultdict(set)
for _ in range(n):
	i, start, end = rl()
	
	
	allowed[i].add((start, end))

print(bfs(x0, y0, x1, y1))


	

