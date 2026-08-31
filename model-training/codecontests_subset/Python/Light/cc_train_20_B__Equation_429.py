a, b, c = map(int, input().split())
d = b * b - 4 * a * c
if not a:
  if not b:
    if not c: print(-1)
    else: print(0)
  else: print(1) or print(-c/b)
else:
  if d < 0: print(0)
  elif not d: print(1) or print((-b + d ** 0.5) / 2 / a)
  else: print(2) or print(min((-b - d ** 0.5) / 2 / a, (-b + d ** 0.5) / 2 / a)) or print(max((-b - d ** 0.5) / 2 / a, (-b + d ** 0.5) / 2 / a))