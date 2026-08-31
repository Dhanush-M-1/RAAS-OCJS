n=int(input())
s=["AC","WA","TLE","RE"]
c=[0]*4
for _ in range(n):
  c[s.index(input())]+=1
for s1,c1 in zip(s,c):
  print(f'{s1} x {c1}')