import random, math, sys
from copy import deepcopy as dc
from bisect import bisect_left, bisect_right
from collections import Counter
 
input = sys.stdin.readline

 
 
# Function to take input
def input_test():



	n, m, k = map(int, input().strip().split(" "))
	grid = []
	for i in range(n):
		grid.append(list(input().strip()))


	def dfsUtil(i, j):
		nonlocal n, m, k, grid
		adj = [
			[0, 1], [0, -1], [1, 0], [-1, 0]
		]
		stack = [[i, j]]

		while stack:
			if k <= 0:
				return
			i, j = stack[-1][0], stack[-1][1]
			stack.pop()

			for kj in adj:
				ni, nj = i + kj[0], j+ kj[1]
				if 0 <= ni < n and 0 <= nj < m and grid[ni][nj] == ".":
					if k <= 0:
						return
					grid[ni][nj] = "Y"
					k -= 1
					# print(i, j, "=>", ni, nj, "K = ", k)
					stack.append([ni, nj])


	li, lj = 0, 0
	s = 0
	for i in range(n):
		for j in range(m):
			if grid[i][j] == ".":
				s += 1
				li, lj = i+1-1, j+1-1
	k = s - k - 1
	grid[li][lj] = "Y"
	dfsUtil(li, lj)
	# print(grid)
	for i in range(n):
		for j in range(m):
			if grid[i][j] == "Y":
				grid[i][j] = "."
			elif grid[i][j] == ".":
				grid[i][j] = "X"

	for row in grid:
		print("".join(row))





# Function to test my code
def test():
	pass
 
 
input_test()
# test()