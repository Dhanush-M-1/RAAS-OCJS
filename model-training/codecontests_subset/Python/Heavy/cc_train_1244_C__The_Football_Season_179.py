import math

def exgcd(a, b, xId, yId):
	if b == 0:
		v[xId] = 1
		v[yId] = 0
		return
	exgcd(b, a % b, yId, xId)
	v[yId] -= v[xId] * (a // b)

(n, c, a, b) = map(int, input().split(' '))
g = math.gcd(a, b)
if c % g > 0:
	print("-1")
	exit(0)
a = a // g
b = b // g
c = c // g
if a < b:
	(a, b) = (b, a)
v = [0, 0]
exgcd(a, b, 0, 1)
x = v[0] * c
y = v[1] * c
lK = (-x - 1) // b + 1
rK = y // a
if lK > rK:
	print("-1")
	exit(0)
x += rK * b
y -= rK * a
if x + y > n:
	print("-1")
	exit(0)
print(x, y, n - x - y)