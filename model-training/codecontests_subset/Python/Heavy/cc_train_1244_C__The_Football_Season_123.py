def gcdExtended(a, b):
  if (a == 0):
    return 0, 1, b
  else:
    x1 = 0
    y1 = 0
    x1, y1, gcd = gcdExtended(b % a, a)
    return y1 - (b // a) * x1, x1, gcd
  
  
  
s = input().split(' ')
n = int(s[0])
p = int(s[1])
w = int(s[2])
d = int(s[3])
x, y, hcf = gcdExtended(w, d)
if (p % hcf):
  print('-1')
else:
  x = (x * (p // hcf))
  y = (y * (p // hcf))
  mink = 0
  maxk = 0
  if (x < y):
    mink = (abs(x) *  hcf) // d
    if (mink * (d // hcf) + x < 0):
      mink += 1
    maxk = (y * hcf) // w
    if (y  - maxk * (w // hcf) < 0):
      maxk -= 1
    mingames = x + y - (maxk * w) / hcf + (maxk * d) / hcf
    if (mingames <= n and mink <= maxk):
      ww = x + (maxk * d) // hcf
      dd = y - (maxk * w) // hcf
      print(ww, dd, n - ww - dd)
    else:
      print('-1')
  else:
    mink = (abs(y) *  hcf) // w
    if (mink * (w // hcf) + y < 0):
      mink += 1
    maxk = (x * hcf) // d
    if (x - maxk * (d // hcf) < 0):
      maxk -= 1
    mingames = x + y + (mink * w) // hcf - (mink * d) // hcf
    if (mingames <= n and mink <= maxk):
      ww = x - (mink * d) // hcf
      dd = y + (mink * w) // hcf
      print(ww, dd, n - ww - dd)
    else:
      print('-1')