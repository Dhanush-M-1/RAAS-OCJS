def fr(a, b):
	if b == 0:
		return [1, 0, a]
	x, y, g = fr(b, a % b)
	return [y, x - (a // b) * y, g]
n, p, w, d = list(map(int, input().split()))
x, y, gc = fr(w, d)
if p % gc:
  print(-1)
else:
  x *= (p // gc)
  y *= (p // gc)
  d1 = d // gc
  d2 = w // gc
  t = (n - x - y) // (d2 - d1)
  if x + y - t * d1 + t * d2 > n:
    t -= 1
  x = x - d1 * t
  y = y + d2 * t
  tt = 0
  if x < 0:
    tt = (-x - 1) // d1 + 1
  X = x + d1 * tt
  Y = y - d2 * tt
  if X >= 0 and Y >= 0 :
    print(X, Y, n - X - Y, end = ' ')
  else:
    print(-1)