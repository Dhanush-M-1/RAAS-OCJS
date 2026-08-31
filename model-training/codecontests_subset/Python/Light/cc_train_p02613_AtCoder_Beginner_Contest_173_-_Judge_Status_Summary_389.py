N = int(input())
d = {'AC': 0, 'WA': 0, 'TLE': 0, 'RE': 0}

for i in range(N):
  v = input()
  d[v] += 1

for k in d:
  print(k + " x " + str(d[k]))