q = int(input())

for i in range(q):
  l, r, d = map(int, input().split())
  if d < l or d > r:
    x = d
  elif d < r:
    resto = r % d
    x = d + (r - resto)
  else:
    x = d + d
  print(x)
