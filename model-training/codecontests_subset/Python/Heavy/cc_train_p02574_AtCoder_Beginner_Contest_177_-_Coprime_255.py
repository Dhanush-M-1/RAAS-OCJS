n=int(input())
l=[*map(int,input().split())]
from math import *
g=l[0]
for x in l:
  g=gcd(g,x)
if g>1: exit(print('not coprime'))
from collections import *
d=Counter()
b=0
for x in l:
  if x%2<1:
    if d[2]:
      b=1
      break
    d[2]=1
  while x%2<1: x//=2
  for i in range(3,int(x**0.5)+1,2):
    if x%i<1:
      if d[i]:
        b=1
        break
      d[i]=1
    while x%i<1: x//=i
    if x<2: break
  if x>1:
    if d[x]:
      b=1
      break
    d[x]=d.get(x,0)+1
print(['pair','set'][b]+'wise coprime')