from math import sqrt
a, b, c = list(map(int,input().strip().split(' ')))
if a == 0:
  if b != 0:
    print(1)
    print(-1 * c/b)
  else:
    if c == 0:
      print(-1)
    else:
      print(0)
else:
  if b ** 2 == 4 * a * c:
    print(1)
    print(-1 * b/(2 * a))
  elif b ** 2 < 4 * a * c:
    print(0)
  else:
    print(2)
    r1 = ((-1 * b) - sqrt(b ** 2 - 4 * a * c))/(2*a)
    r2 = ((-1 * b) + sqrt(b ** 2 - 4 * a * c))/(2*a)
    if r1 < r2:
      print(r1)
      print(r2)
    else:
      print(r2)
      print(r1)