#!/usr/bin/env python3
# http://codeforces.com/problemset/problem/805/A

import sys

from collections import deque
from collections import defaultdict

L, R = sys.stdin.readline().strip().split(' ')
L = int(L)
R = int(R)
counts = {}
max_divisor_count = 1 
max_divisor = 1 

def primes(n, counts):
	global max_divisor, max_divisor_count
	fac = set()
	d = 2
	print('n: {}'.format(n))
	while d <= n:
		while (n % d) == 0:
			print("d: {}".format(d))
			if d not in fac:
				if d not in counts:
					counts[d] = 1
				else: 
					counts[d] += 1
				if counts[d] > max_divisor_count:
					max_divisor_count = counts[d]
					max_divisor = d 
				fac.add(d)
			n //= d
		d += 1
	if n > 1:
		fac.add(n)
	return fac

# mult = 1 
# d = deque()
# for i in range(L, R + 1):
# 	print("i1: {}".format(i))
# 	d.append(i)

# while len(d) != 0:
# 	i = d.popleft()
# 	print("i: {}".format(i))
# 	mult = R // i
# 	for k in range(2, mult + 1):
# 		# print (i * k)
# 		d.remove(i * k)
# 	# get prime factorization for item i
# 	primefac = primes(i, counts)

# print(counts)
# print(max_divisor)

# if ((R - L) % 2 == 0) or (R - L) == 1 or (R - L) == 5:
# 	print (2)
# else: 
# 	print (3)

if R == L:
	print (R)
else:
	print(2)
