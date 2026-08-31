t = int(input())
anss = []

for _ in range(t):
  input()
  l = list(map(int, input().split(sep=' ')))
  if l[0] + l[1] > l[-1]:
    anss.append([-1])
  else:
    anss.append([1, 2, len(l)])

for ans in anss:
  for i in ans:
    print(i, end = ' ')
  print()
