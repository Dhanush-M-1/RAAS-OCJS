
import sys
import math
from math import *
from collections import Counter,defaultdict,deque
from bisect import bisect_left
import random
         

lip = lambda : list(map(int, input().split()))
ip = lambda : int(input())
sip = lambda : input().split()
mod = 10**9+7
 
 
def main():

	n = ip()
	mat = []
	for i in range(n):
		mat.append(input())
	ctr = 0
	if mat[0][1] == '1':
		ctr += 1

	if mat[1][0] == '1':
		ctr += 1

	c = 0
	if mat[-1][-2] == '1':
		c += 1
	if mat[-2][-1] == '1':
		c += 1

	if ctr == 0:
		if c == 2:
			print(0)
		elif c == 0:
			print(2)
			print(n,n-1)
			print(n-1,n)

		else:
			print(1)
			if mat[-2][-1] == '1':
				print(n,n-1)
			else:
				print(n-1,n)

	elif ctr == 2:

		if c == 0:
			print(0)
		elif c == 2:
			print(2)
			print(n,n-1)
			print(n-1,n)

		else:
			print(1)
			if mat[-2][-1] == '0':
				print(n,n-1)
			else:
				print(n-1,n)

	else:
		if c == 2:
			print(1)
			if mat[0][1] == '1':
				print(1,2)
			else:
				print(2,1)

		elif c == 0:
			print(1)
			if mat[0][1] == '0':
				print(1,2)
			else:
				print(2,1)

		else:
			print(2)
			if mat[0][1] == '0':
				print(1,2)
			if mat[1][0] == '0':
				print(2,1)
			if mat[-1][-2] == '1':
				print(n,n-1)
			if mat[-2][-1] == '1':
				print(n-1,n)


for i in range(ip()):
	main()
