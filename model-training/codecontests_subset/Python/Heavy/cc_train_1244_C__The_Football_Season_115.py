# -*- coding: utf-8 -*-
# @Author: apikdech
# @Date:   19:41:04 14-10-2019
# @Last Modified by:   apikdech
# @Last Modified time: 20:04:46 14-10-2019
def gcd(a, b):
	if a == 0:
		return (0, 1, b)
	x1, y1, d = gcd(b % a, a)
	x = y1 - (b // a) * x1
	y = x1
	return (x, y, d)

def find_any_solution(a, b, c):
	x0, y0, g = gcd(a, b)
	if c % g != 0:
		return (-1, -1, -1)
	x0 *= c // g
	y0 *= c // g
	return (x0, y0, g)

def shift_solution(x, y, a, b, cnt):
	x += cnt * b
	y -= cnt * a
	return (x, y)

def find_all_solutions(a, b, c, minx, maxx, miny,  maxy):
	x, y, g = find_any_solution(a, b, c)
	if x == -1 and y == -1 and g == -1:
		return (-1, -1)
	a //= g
	b //= g
	sign_a = 1 if a > 0 else -1
	sign_b = 1 if b > 0 else -1
	x, y = shift_solution(x, y, a, b, (minx - x) // b)
	if x < minx:
		x, y = shift_solution(x, y, a, b, sign_b)
	if x > maxx:
		return (-1, -1)
	lx1 = x
	x, y = shift_solution(x, y, a, b, (maxx - x) // b)
	if x > maxx:
		x, y = shift_solution(x, y, a, b, -sign_b)
	rx1 = x
	x, y = shift_solution(x, y, a, b, -(miny - y) // a)
	if y < miny:
		x, y = shift_solution(x, y, a, b, -sign_a)
	if y > maxy:
		return (-1, -1)
	lx2 = x
	x, y = shift_solution(x, y, a, b, -(maxy - y) // a)
	if y > maxy:
		x, y = shift_solution(x, y, a, b, sign_a)
	rx2 = x
	if lx2 > rx2:
		lx2, rx2 = rx2, lx2

	lx = max(lx1, lx2)
	rx = min(rx1, rx2)
	if lx > rx:
		return (-1, -1)
	return (lx, rx)

n, p, w, d = map(int, input().strip().split())

lx, rx = find_all_solutions(w, d, p, 0, int(1e12), 0, int(1e12))

x0 = rx
y0 = (p - w*rx)//d
z0 = n - (x0 + y0)
if lx == -1 and rx == -1:
	print(-1)
elif z0 < 0:
	print(-1)
else:
	print(str(x0) + ' ' + str(y0) + ' ' + str(z0))