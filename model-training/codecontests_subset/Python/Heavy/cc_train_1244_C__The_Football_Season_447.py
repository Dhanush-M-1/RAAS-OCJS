def xgcd(a, b):
    x0, x1, y0, y1 = 0, 1, 1, 0
    while a != 0:
        q, b, a = b // a, a, b % a
        y0, y1 = y1, y0 - q * y1
        x0, x1 = x1, x0 - q * x1
    return b, x0, y0
 
n, p, w, d = map(int, input().split())
 
g, a, b = xgcd(w, d)
 
if p % g != 0:
  print(-1)
  exit(0)
 
a *= p // g;
b *= p // g;
 
if b < 0:
  t = (-b + (w // g) - 1) // (w // g);
  a -= t * (d // g);
  b += t * (w // g);
 
t = b // (w // g);
a += t * (d // g);
b -= t * (w // g);
 
if a >= 0 and b >= 0 and a + b <= n:
  print(a, b, n - a - b)
else:
  print(-1)