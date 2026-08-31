from math import ceil
q = int(input())
for i in range(q):
  l, r, d = map(int, input().split())

  if l > d:
    print(d)
  elif d > r:
    print(d)
  else:
    if r%d == 0:
      print((ceil(r/d)+1)*d)
    else:
      print((ceil(r/d))*d)
