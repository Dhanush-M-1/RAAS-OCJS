cases=int(input())
for _ in range(cases):
  n = int(input())
  grid = []
  for _ in range(n):
    grid.append(list(input()))
  op = cl = None
  perms = []
  if grid[0][1] == grid[1][0]:
    op = grid[0][1]
  if grid[-1][-2] == grid[-2][-1]:
    cl = grid[-1][-2]
  if op and cl and op == cl:
    print(2)
    print(1, 2)
    print(2, 1)
  elif op and cl:
    print(0)
  elif op:
    print(1)
    if grid[-1][-2] == op:
      print(n, n-1)
    else:
      print(n-1, n)
  elif cl:
    print(1)
    if grid[0][1] == cl:
      print(1, 2)
    else:
      print(2, 1)
  else:
    print(2)
    print(1, 2)
    if grid[0][1] == grid[-1][-2]:
      print(n-1, n)
    else:
      print(n, n-1)