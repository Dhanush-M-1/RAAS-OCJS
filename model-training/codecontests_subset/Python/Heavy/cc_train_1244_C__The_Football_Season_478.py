def iceil(n, x):
	return (n + x - 1) // x

#Stores into x & y values such that a*x+b*y=gcd(a,b) which depends 
#on the values to be in the next iteration x1 & y1
#and also returns gcd(a,b).
def extendedEuclidean(a, b):
	if b == 0:
		return (a, 1, 0)
	(g, x1, y1) = extendedEuclidean(b, a % b)
	x = y1
	y = x1 - (a // b) * y1
	return (g, x, y)

n, p, w, d = [int(x) for x in input().split()]
a, b = w, d

(g, x, y) = extendedEuclidean(w, d)
# print(x, w, y, d, g)

if p % g:
	print(-1)
	exit(0)

x *= p // g
y *= p // g

a = w // g
b = d // g

# print(x, y)

if x < 0:
	k = iceil(-x, b)
	x += k * b
	y -= k * a

# print(x, y)

if y < 0:
	k = iceil(-y, a)
	y += k * a
	x -= k * b

# print(x, y)

if x < 0:
	print(-1)
	exit(0)

k = y // a
x += k*b
y -= k*a
z = n - x - y

# print(x, y)

if x + y > n:
	print(-1)
	exit(0)

print(x, y, z)
assert(x*w + y*d == p)