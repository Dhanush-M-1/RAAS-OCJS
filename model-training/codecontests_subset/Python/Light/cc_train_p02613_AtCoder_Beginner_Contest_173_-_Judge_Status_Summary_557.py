n=int(input())
s=[input() for _ in range(n)]

for x in ['AC','WA','TLE','RE']:
  print(x+' x '+str(s.count(x)))