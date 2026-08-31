n=int(input())

listA=[input() for i in range(n)]

d=dict(AC=0, WA=0, TLE=0, RE=0)

for s in listA:
  d[s]+=1
for k,v in d.items():
  print(k,'x',v)