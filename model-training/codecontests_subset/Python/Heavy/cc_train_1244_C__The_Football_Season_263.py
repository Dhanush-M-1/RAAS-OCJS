def gcd(a, b):
	if a == 0:
		return [b, 0, 1]
	arr = gcd(b % a, a)
	x = arr[2] - (b // a) * arr[1]
	y = arr[1]
	return [arr[0], x, y]

n, p, w, d = (int(x) for x in input().split())
arr = gcd(w, d)
g, x, y = arr[0], arr[1], arr[2]
if p % g != 0:
	print(-1)
	exit(0)
x *= p // g
y *= p // g
addx = d // g
addy = w // g
if x < 0:
	need = (-x + addx - 1) // addx
	x += need * addx
	y -= need * addy
else:
	can = x // addx
	x -= can * addx
	y += can * addy
if x < 0 or y < 0:
	print(-1)
	exit(0)
if x + y <= n:
	print(x, end = ' ')
	print(y, end = ' ')
	print(n - x - y)
	exit(0)
need = x + y - n
can = y / addy
dx = addy - addx
if dx <= 0:
	print(-1)
	exit(0)
cnt = (need + dx - 1) // dx
if cnt > can:
	print(-1)
	exit(0)
x += cnt * addx
y -= cnt * addy
print(x, end = ' ')
print(y, end = ' ')
print(n - x - y)

	