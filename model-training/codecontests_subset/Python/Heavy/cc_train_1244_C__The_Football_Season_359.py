reads = lambda: [int(x) for x in input().split()]
read = lambda: int(input())
from math import gcd
def egcd(a, b):
  x,y, u,v = 0,1, 1,0
  while a != 0:
    q, r = b//a, b%a
    m, n = x-u*q, y-v*q
    b,a, x,y, u,v = a,r, u,v, m,n
  gcd = b
  return gcd, x, y

def main():
  n, p, w, d = reads()
  g = gcd(w, d)
  if p % g:
    return -1,
  _, x, y = egcd(w, d)
  x *= p // g
  y *= p // g
  if y < 0:
    k = w // g
    s = (-y + k - 1) // k
    y += s * k
    x -= s * (d // g)
  else:
    k = w // g
    s = y // k
    y -= s * k
    x += s * (d // g)
  assert y >= 0
  if x < 0 or x + y > n:
    return -1,
  return x, y, n - x - y
  
print(*main())
