from math import pi, sqrt

n, Px, Py = map(int, input().split())
r_min = 1000000000000.0
r_max = 0.0
X = []
Y = []
for i in range (n):
	x, y = map(int, input().split())
	X += [x - Px]
	Y += [y - Py]
for i in range (n):
	x1 = X[i - 1]
	y1 = Y[i - 1]
	x2 = X[i]
	y2 = Y[i]
	vector_x = x2 - x1
	vector_y = y2 - y1
	normal_x = vector_y
	normal_y = -vector_x
	A = normal_x
	B = normal_y
	C = -1 * A * x1 + -1 * B * y1
	d = C / sqrt(A * A + B * B)
	if (normal_x * y1 - normal_y * x1) * (normal_x * y2 - normal_y * x2) < 0:
		r_min = min(r_min, abs(d))
	else:
		r_min = min(r_min, sqrt(x1 * x1 + y1 * y1), sqrt(x2 * x2 + y2 * y2))
	r_max = max(r_max, sqrt(x1 * x1 + y1 * y1), sqrt(x2 * x2 + y2 * y2))
print(pi * (r_max * r_max - r_min * r_min))
