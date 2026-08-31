#!/usr/bin/env python3

import sys

def common_sub(a1, a2):
	
	found = False
	for c in a1:
		if c in a2 and not found:
			print("YES")
			print("1 " + c)
			found = True
			continue
	
	if not found:
		print("NO")

if __name__ == '__main__':

	num_tests = int(next(sys.stdin).strip())

	for x in range(num_tests):
		# print("x: " + str(x))
		next(sys.stdin) # we do not need the array lengths in python
		# n, m = map(int, next(sys.stdin).strip().split(' '))
		# print("n: " + str(n))
		# print("m: " + str(m))

		a1 = next(sys.stdin).strip().split(' ')
		a2 = next(sys.stdin).strip().split(' ')
		# print("a1: " + str(a1))
		# print("a2: " + str(a2))

		common_sub(a1, a2)

		

