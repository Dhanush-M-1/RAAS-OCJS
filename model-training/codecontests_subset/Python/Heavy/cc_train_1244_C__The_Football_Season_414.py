n, p, w, d = map(int, input().split())

x = y = 0

def gcd_ext(a,b):
  global x,y
  if a == 0:
    x, y = 0, 1
    return b
  d = gcd_ext(b % a, a)
  x, y = y - (b // a) * x, x
  return d

t = gcd_ext(w, d)
if p % t != 0:
  print(-1)
else:
  x *= (p // t)
  y *= (p // t)
  if x < 0:
    m = (abs(x) - 1) // (d // t) + 1
    y -= m * (w // t)
    x += m * (d // t)
  if x > y:
    m = x // (d // t)
    x -= m * (d // t)
    y += m * (w // t)
  sx, sy = x, y
  
  def f(m):
    x = sx + m * (d // t)
    y = sy - m * (w // t)
    if y < 0:
      return 10**18
    return x + y

  left = 0
  right = p+1
  while right - left > 2:
    m1 = left + (right - left) // 3
    m2 = m1 + (right - left) // 3
    if f(m1) > f(m2):
      left = m1
    else:
      right = m2
  m = left
  if f(left + 1) < f(m):
    m = left + 1
  if f(right) < f(m):
    m = right

  x = sx + m * (d // t)
  y = sy - m * (w // t)
  
  """
  if y < 0:
    m = (abs(y) - 1) // (w // t) + 1
    x -= m * (d // t)
    y += m * (w // t)
  while x + y > n and y >= 0:
    x += d // t
    y -= w // t
  """
  if x + y <= n and x >= 0 and y >= 0:
    print(x, y, n-(x+y))
  else:
    print(-1)
  
