import sys
import math
import random
from typing import List

# sys.stdin = open('input.txt', 'r')
# sys.stdout = open('output.txt', 'w')

input = sys.stdin.readline


class Cell:
	def __init__(self, a, row, col):
		self.a = a
		self.row = row
		self.col = col

	def value(self):
		return self.a[self.row][self.col]


def solve(n, c1, c2, c3, c4) -> List[Cell]:
	def convert(c1: Cell, c2: Cell, char):
		ans = []
		if c1.value() != char:
			ans.append(c1)
		if c2.value() != char:
			ans.append(c2)
		return ans


	# print(n, c1, c2, c3, c4)
	sol1 = convert(c1, c2, '0') + convert(c3, c4, '1')
	sol2 = convert(c1, c2, '1') + convert(c3, c4, '0')
	return sol1 if len(sol1) < len(sol2) else sol2


T = int(input())
for t in range(T):
	N = int(input())
	A = []
	for i in range(N):
		A.append(input())
	solution = solve(
		N,
		Cell(A, 1, 0), Cell(A, 0, 1),
		Cell(A, N-1, N-2), Cell(A, N-2, N-1)
	)
	print(len(solution))
	for cell in solution:
		print(cell.row + 1, cell.col + 1)