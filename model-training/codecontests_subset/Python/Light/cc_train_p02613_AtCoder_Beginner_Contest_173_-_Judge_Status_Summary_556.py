n = int(input())
d={'AC':0, 'WA':0, 'TLE':0, 'RE':0}

for i in range(n):
  s = input()
  d[s] += 1
for s,k in d.items():
  print(s, "x", k)