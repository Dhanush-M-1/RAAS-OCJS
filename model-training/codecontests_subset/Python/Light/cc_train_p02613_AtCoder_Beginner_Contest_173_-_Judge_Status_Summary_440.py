N = int(input())
S = [input() for _ in range(N)]

for ret in ['AC', 'WA', 'TLE', 'RE'] :
  print(ret, 'x', S.count(ret))