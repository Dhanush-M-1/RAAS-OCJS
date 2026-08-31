#=================================
# Author: Danish Amin
# Date: Fri Oct 23 19:09:09 2020
#=================================
import sys; input = sys.stdin.readline

for i in range(int(input())):
	n = int(input())
	matrix = [list(input().strip()) for _ in range(n)]
	a, b, c, d = int(matrix[1][0]), int(matrix[0][1]), int(matrix[-1][-2]), int(matrix[-2][-1])
	A, B, C, D = [(2, 1), (1, 2), (n, n-1), (n-1, n)]
	if a == b == c == d: 
		print(2)
		print(*A)
		print(*B)
	elif 1*(not a) == b == c == d: print(1); print(*B)
	elif 1*(not b) == a == c == d: print(1); print(*A)
	elif 1*(not c) == a == b == d: print(1); print(*D)
	elif 1*(not d) == a == c == b: print(1); print(*C)
	elif a == 1*(not b) and c == 1*(not d):
		print(2)
		if a == c:
			print(*B)
			print(*C)
		else:
			print(*B)
			print(*D)
	else: print(0)
