import math

def extended_euclid(a, b):
    """return (g, x, y) such that a*x + b*y = g = gcd(a, b)"""
    x0, x1, y0, y1 = 0, 1, 1, 0
    while a != 0:
        (q, a), b = divmod(b, a), a
        y0, y1 = y1, y0 - q * y1
        x0, x1 = x1, x0 - q * x1
    return b, x0, y0

n, p, w, d = [int(i) for i in input().split(' ')]

a = w
b = d
c = p

g, x, y = extended_euclid(a, b)

if c % g != 0:
	print("-1")
else:
	b //= g
	a //= g
	x = x * (c // g)
	y = y * (c // g)

	#f1 = math.ceil((-x) / b)
	f2 = y // a
	#print(f2)
# 	if y < 0 and f2 * a != y:
# 		f2 = f2 - 1
	#if f1 <= f2:
	x += f2 * b;
	y -= f2 * a;
	if x >= 0 and y >= 0 and x + y <= n:
		print(str(x) + " " + str(y) + " " + str(n-x-y))
	else:
		print("-1")
	#else:
	#	print("-1")