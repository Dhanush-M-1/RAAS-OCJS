from math import *
 
def ri():
    return int(input())
 
def rl():
    return list(map(int, input().split()))
"""
based on editorial
"""
def ternary_search(f, a, b, tol):
	"""
	we assume that f is stricly decreasing then strictly 
	increasing on [a,b]
	"""
	while (b - a) >= tol:
		alpha = 1/3
		c = (1-alpha) * a + alpha * b
		d  = alpha * a + (1 - alpha) * b
		fc = f(c)
		fd = f(d)

		if fc < fd:
			b = d
		else:
			a  = c

	return a

def f(alpha):
	x = radius  * cos(alpha)
	y  = radius * cos(pi /(2* n) - alpha)
	return max(2*x, 2*y)

t = ri()
for i in range(t):
    n = ri()
    
    radius = 1 / (2 * sin(pi / (2*n)))
    tol  = 1 / (10**6)
    alpha  = ternary_search(f, 0, pi / (2*n), tol)
    print(f(alpha))