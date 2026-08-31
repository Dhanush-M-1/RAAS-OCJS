#init
N = int(input())
S=[input() for i in range(N)]
for word in ['AC', 'WA', 'TLE', 'RE']:
  print('{0} x {1}'.format(word, S.count(word)))