n, k = [int(i) for i in input().split()]
a1 = []
a2 = []
a3 = []
A1 = False
A2 = False
A3 = False
amount = 0
summ = 0
for i in range(n):
  t, a, b = [int(z) for z in input().split()]
  if a == 1 and b == 1:
    a1.append(t)
    A1 = True
  elif a == 1:
    a2.append(t)
    A2 = True
  elif b == 1:
    a3.append(t)
    A3 = True
a1 = sorted(a1)
a2 = sorted(a2)
a3 = sorted(a3)
if len(a1) + min(len(a2), len(a3)) < k:
  print(-1)
else:
  x, y = 0, 0
  len1 = len(a1)
  len2 = len(a2)
  len3 = len(a3)
  while amount < k:
    if x == len2 or x == len3:
      summ += sum(a1[y:y+k-amount])
      break
    if y == len1:
      summ += sum(a2[x:x+k-amount] + a3[x:x+k-amount])
      break
    if a3[x] + a2[x] < a1[y]:
      summ += a3[x] + a2[x]
      x += 1
      amount += 1
    else:
      summ += a1[y]
      y += 1 
      amount += 1
  print(summ)