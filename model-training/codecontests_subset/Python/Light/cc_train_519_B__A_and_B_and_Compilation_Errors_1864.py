n = int(input())
ds = [{}, {}, {}]
for i in range(3):
  keys = input().split()
  for k in keys:
    try:
      ds[i][k] += 1
    except KeyError:
      ds[i][k] = 1
for i in range(2):
  for k in ds[i]:
    try:
      if ds[i+1][k] != ds[i][k]:
        print(k)
        break
    except KeyError:
      print(k)
      break