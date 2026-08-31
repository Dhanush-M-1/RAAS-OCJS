import sys
import math
 
def read_line():
	return sys.stdin.readline()[:-1]
 
def read_int():
	return int(sys.stdin.readline())
 
def read_int_line():
	return [int(v) for v in sys.stdin.readline().split()]

t = read_int()
for i in range(t):
	n,m = read_int_line()
	s = read_line()
	p = read_int_line()
	c = [0]*n
	for i in range(len(p)):
		c[0] += 1
		c[p[i]] -= 1
	for i in range(1,n):
		c[i] += c[i-1]
	for i in range(n):
		c[i] +=1
	d = [0]*26
	for i in range(len(c)):
		d[(ord(s[i])-ord("a"))] += c[i]
	print(*d)