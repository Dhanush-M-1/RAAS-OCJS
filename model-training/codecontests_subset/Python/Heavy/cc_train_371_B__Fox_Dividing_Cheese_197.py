'''input
6 6
'''
# connected components
from sys import stdin
from collections import defaultdict
import sys

sys.setrecursionlimit(15000)


def factors(num, arr):
	count = 0
	while num % 2 == 0:
		num //= 2
		count += 1
	arr.append(count)
	
	count  = 0
	while num % 3 == 0:
		num //= 3
		count += 1
	arr.append(count)

	count  = 0
	while num % 5 == 0:
		num //= 5
		count += 1
	arr.append(count)

	arr.append(num)


# main starts
a, b = list(map(int, stdin.readline().split()))
A = []
B = []
factors(a, A)
factors(b, B)
if A[3] == B[3]:
	print(abs(A[0] - B[0]) + abs(A[1] - B[1])  + abs(A[2] - B[2]))
else:
	print(-1)