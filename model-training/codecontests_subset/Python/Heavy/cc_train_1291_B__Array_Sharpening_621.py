import math

t = int(input())

for _ in range(t):
  n = int(input())
  a = [int(c) for c in input().split()]
  increasing = True
  res = 'Yes'
  for i in range(n):
    if increasing:
      if a[i] >= i:
        continue
      else:
        increasing = False
        if a[i] >= n - 1 - i and a[i - 1] >= max(i - 1, n - i):
          continue
        else:
          res = 'No'
          break
    else:
      if a[i] >= n - 1 - i:
        continue
      else:
        res = 'No'
        break
  print(res)
