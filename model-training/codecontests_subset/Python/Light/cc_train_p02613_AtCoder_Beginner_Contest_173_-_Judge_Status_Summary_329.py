N = int(input())
S = [input() for _ in range(N)]
lis = ['AC','WA','TLE','RE']
for l in lis:
  print('{} x {}'.format(l,S.count(l)))