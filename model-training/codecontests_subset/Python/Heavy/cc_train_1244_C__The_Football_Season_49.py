def gcd(a, b):
  if a == 0:
    return 0, 1, b
  x1, y1, g = gcd(b % a, a)
  x = y1 - (b // a) * x1
  y = x1
  return x, y, g


def sgn(a):
  return 1 if a >= 0 else -1

def integer_division(a, b):
  return sgn(a) * sgn(b) * (abs(a) // abs(b))

n, p, w, d = map(int, input().split())

x0, y0, g = gcd(w, d)

if p % g != 0:
  print(-1)
  exit(0)

x0 = x0 * integer_division(p, g)
y0 = y0 * integer_division(p, g)

mint = integer_division(-x0 * g, d)
if mint >= 0 and (x0 * g) % d != 0: mint = mint + 1

maxt = integer_division(y0 * g, w)
if maxt <= 0 and (y0 * g) % w != 0: maxt = maxt - 1

mint_n = -integer_division((n - x0 - y0) * g, w - d)
if mint_n >= 0 and ((n - x0 - y0) * g) % (w - d) != 0: mint_n = mint_n + 1

if mint <= maxt and mint_n <= maxt:
  x = x0 + integer_division(d, g) * maxt
  y = y0 - integer_division(w, g) * maxt
  print(x, y, n - x - y)
else:
  print(-1)
