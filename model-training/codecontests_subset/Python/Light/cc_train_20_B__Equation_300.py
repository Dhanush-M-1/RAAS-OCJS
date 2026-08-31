import math

def solve_const(x):
	if(x == 0):
		print(-1)
	else:
		print(0)

def solve_lineal(x, y):
	if(y == 0):
		#yt = 0 => t = 0
		print(1)
		print(0)
	else:
		#xt + y = 0 => t = -y/x
		print(1)
		print(-y / x)

def solve_square(x, y, z):
	d = y * y - 4 * x * z
	if(d < 0):
		print(0)
	elif(d > 0):
		print(2)
		x1 = (-y + math.sqrt(d)) / (2 * x)
		x2 = (-y - math.sqrt(d)) / (2 * x)
		print(min(x1, x2))
		print(max(x1, x2))
	else:
		print(1)
		print((-y) / (2 * x))
		
a, b, c = map(int, input().split())

if(a == 0):
	if(b == 0):
		solve_const(c)
	else:
		solve_lineal(b, c)
else:
	solve_square(a, b, c)