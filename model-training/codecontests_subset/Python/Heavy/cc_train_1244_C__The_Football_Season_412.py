import math

def extended_euclidean(a, b):
	if b == 0:
		return 1, 0, a
	x1, y1, g = extended_euclidean(b, a%b)
	x, y = y1, x1 - (a//b)*y1
	return x, y, g

def floor(a, b):
	if a >= 0:
		return a//b

	return -1 - ((-a)//b)

n, p, w, d = [int(x) for x in input().split()]
x0, y0, g = extended_euclidean(w, d)

if p%g != 0:
	print(-1)
	exit(0)

x0 *= p//g
y0 *= p//g

#x = x0 - k (d/g)
#y = y0 + k (w/g)
#x0 + y0 + k(w - d)/g<= n
#

mnk = floor(-y0 + (w//g) - 1, (w//g))
mxk = min(floor(x0, d//g), floor(n - x0 - y0, (w - d)//g))
if mnk > mxk:
	print(-1)
	exit(0)

k = mnk
x = x0 - k*(d//g)
y = y0 + k*(w//g)
z = n - x - y
print(x, y, z)
