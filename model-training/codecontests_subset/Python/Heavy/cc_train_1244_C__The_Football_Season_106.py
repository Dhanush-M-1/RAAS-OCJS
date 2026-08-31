def GCD(a, b):
	if b == 0:
	    return (1, 0)
	pres = GCD(b, a % b)
	return (pres[1], pres[0] - (a // b) * pres[1])

n, p, a, b = list(map(int, input().split()))
x, y = GCD(a, b)
d = a * x + b * y
a //= d
b //= d
if p % d:
    print(-1)
    exit(0)
x *= p // d
y *= p // d
if (x < 0):
	tmp = (-x + b - 1) // b
	x += b * tmp
	y -= a * tmp
if y < 0:
	tmp = (-y + a - 1) // a
	y += a * tmp
	x -= b * tmp
if x < 0 or y < 0:
	print(-1)
	exit(0)
tmp = y // a
y -= a * tmp
x += b * tmp
if x + y > n:
	print(-1)
	exit(0)
print(x, y, n - x - y)

