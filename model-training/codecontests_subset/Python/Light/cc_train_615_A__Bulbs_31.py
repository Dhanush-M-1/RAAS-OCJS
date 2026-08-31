n, m = [int(x) for x in input().split(' ')]
y = list(range(1, m + 1))
for i in range(n):
  k, *a = [int(x) for x in input().split(' ')]
  for x in a:
    if x in y: y.remove(x)
if len(y) == 0:
  print('YES')
else:
  print('NO')
