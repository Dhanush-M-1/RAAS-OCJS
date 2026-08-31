n = int(input())
s = [input() for _ in range(n)]

cs = ('AC', 'WA', 'TLE', 'RE')

for c in cs:
  print('{} x {}'.format(c, s.count(c)))
