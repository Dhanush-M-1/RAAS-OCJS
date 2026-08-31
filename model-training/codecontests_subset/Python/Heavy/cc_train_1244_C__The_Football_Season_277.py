def exgcd(a, b) :
  x, y, xx, yy = 1, 0, 0, 1
  while b != 0 :
    q = a // b
    a, b = b, a % b
    x, xx = xx, x - q * xx
    y, yy = yy, y - q * yy
  return a, x, y

n, p, w, d = map(int, input().split())

g, x, y = exgcd(w, d)

if p % g != 0 :
  print(-1)
  exit(0)

x *= p // g
y *= p // g

dx, dy = d // g, w // g

if y < 0 :
  steps = (-y + dy - 1) // dy
else :
  steps = - (y // dy)

xc, yc = x - dx * steps, y + dy * steps

if xc >= 0 and yc >= 0 and xc + yc <= n :
  print(xc, yc, n-xc-yc)
  exit(0)


if x < 0 :
  steps = (-x + dx - 1) // dx
else :
  steps = - (x // dx)

xc, yc = x + dx * steps, y - dy * steps

if xc >= 0 and yc >= 0 and xc + yc <= n :
  print(xc, yc, n-xc-yc)
  exit(0)

print(-1)
