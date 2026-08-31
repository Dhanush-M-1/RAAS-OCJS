d = {"AC":0, "WA":0, "TLE":0, "RE":0}
n = int(input())
for i in range(n):
  x = input()
  d[x] = d[x] + 1
for i in d:
  print(i, "x", d[i])