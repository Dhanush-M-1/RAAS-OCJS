n=int(input())
a=[input() for _ in range(n)]
for s in ['AC', 'WA', 'TLE', 'RE']:
  print(s,'x',a.count(s))