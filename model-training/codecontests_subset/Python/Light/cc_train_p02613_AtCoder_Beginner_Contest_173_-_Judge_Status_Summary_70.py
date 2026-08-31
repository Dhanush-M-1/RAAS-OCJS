n=int(input())
c={}
for _ in range(n):
  s=input()
  c[s]=c.get(s,0)+1
for j in ('AC','WA','TLE','RE'):
  print(j,'x',c.get(j,0))