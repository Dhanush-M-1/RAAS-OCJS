n=int(input())
d={"AC":0,"WA":0,"TLE":0,"RE":0}
for _ in range(n):
  d[input()]+=1

for d1, d2 in d.items():
  print(d1,'x',d2) 