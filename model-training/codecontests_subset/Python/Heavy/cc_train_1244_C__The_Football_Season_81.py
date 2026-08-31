
def gcd(a, b):
  return a if b == 0 else gcd(b, a % b)
def exgcd(a, b):
  if b == 0:
    return (a, (1, 0))
  res = exgcd(b, a % b)
  return (res[0], (res[1][1], res[1][0] - a // b * res[1][1]))
def up(x, y):
  if x >= 0:
    return x // y + (1 if x % y > 0 else 0)
  return -(-x // y)
def down(x, y):
  if x >= 0:
    return x // y
  else:
    return -(-x // y + (1 if -x % y > 0 else 0))

if __name__ == '__main__':
  n, p, w, d = input().split(' ')
  n = int(n)
  p = int(p)
  w = int(w)
  d = int(d)
  g = gcd(w, d)
  if p % g != 0:
    print(-1)
  else:
    w //= g
    d //= g
    p //= g
    res = exgcd(w, d)
    mink = max(up(-res[1][0] * p, d), up(p * res[1][0] + p * res[1][1] - n, w - d))
    maxk = down(res[1][1] * p, w)
    if mink > maxk:
      print(-1)
    else:
      x = p * res[1][0] + mink * d
      y = p * res[1][1] - mink * w
      print(f'{x} {y} {n - x - y}')