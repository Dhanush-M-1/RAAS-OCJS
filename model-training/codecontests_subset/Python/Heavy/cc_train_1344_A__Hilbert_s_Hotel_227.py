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

t = read_int()
for i in range(t):
	n = read_int()
	a = read_int_line()

	d= {}

	for i in range(n):
		d[i] = (i+a[i])%n


	l = list(d.values())

	d = {}

	for i in l:
		if i in d:
			d[i] +=1
		else:
			d[i] = 1

	l = list(d.values())

	l.sort(reverse=True)

	if l[0] > 1:
		print("NO")
	else:
		print("YES")