n = int(input())
a = [input() for i in range(n)]

for v in ['AC', 'WA', 'TLE', 'RE']:
  print(f'{v} x {a.count(v)}')
    
