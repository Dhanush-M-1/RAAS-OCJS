#                                               |
#   _` |  __ \    _` |   __|   _ \   __ \    _` |   _` |
#  (   |  |   |  (   |  (     (   |  |   |  (   |  (   |
# \__,_| _|  _| \__,_| \___| \___/  _|  _| \__,_| \__,_|

import sys
import math

def read_line():
	return sys.stdin.readline()[:-1]
 
def read_int():
	return int(sys.stdin.readline())
	
def read_int_line():
	return [int(v) for v in sys.stdin.readline().split()]

def read_float_line():
	return [float(v) for v in sys.stdin.readline().split()]

n = read_int()

d = {}

for i in range(n-1):
	u, v = read_int_line()
	if u in d:
		d[u] += 1
	else:
		d[u] = 1

	if v in d:
		d[v] += 1
	else:
		d[v] = 1


f = False

for i in d:
	if d[i]==2:
		f = True

if f:
	print("NO")
else:
	print("YES")

	