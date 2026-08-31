'''input
2
1000000 1000000
'''
from sys import stdin, stdout
import sys
import math

sys.setrecursionlimit(15000)

def get_count(arr):
	even = []
	odd = []
	for i in arr:
		if i % 2 == 0:
			even.append(i)
		else:
			odd.append(i)
	return even, odd


# main starts
n = int(stdin.readline().strip())
arr = list(map(int, stdin.readline().split()))
arr.sort()
even, odd = get_count(arr)
if len(even) < len(odd):
	while len(even) > 0:
		if len(even) > 0:
			even.pop()
		odd.pop()
	if len(odd) > 0:
		odd.pop()
	print(sum(even) + sum(odd))


else:
	while len(odd) > 0:
		if len(odd) > 0:
			odd.pop()
		even.pop()
	if len(even) > 0:
		even.pop()
	print(sum(even) + sum(odd))