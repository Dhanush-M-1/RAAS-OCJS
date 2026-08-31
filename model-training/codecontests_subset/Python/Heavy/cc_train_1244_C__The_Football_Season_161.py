x = 0
y = 0

def gcd (a, b):
	global x, y
	if a == 0:
		x = 0
		y = 1
		return b
	
	d = gcd(b % a, a)	
	x, y = y - (b // a) * x, x			
	return d
	
	
n, p, w, d = map(int, input().split())

g = gcd(w, d)
if p % g != 0:
	print(-1)
	exit(0)
	
x *= p // g
y *= p // g

w //= g
d //= g

if y < 0:
	l = -1
	r = 10**80 + 3
	
	while r - l > 1:
		k = l + (r - l) // 2
		if y + k * w >= 0:
			r = k
		else:
			l = k
		
	if y + r * w < 0 or x - r * d < 0:
		print(-1)
		exit(0)
			
	y += r * w
	x -= r * d
else:
	dif = y // w
	x += dif * d
	y -= dif * w

if x < 0 or y < 0 or x + y > n:
	print(-1)
	exit(0)

print(x, y, n - x - y)