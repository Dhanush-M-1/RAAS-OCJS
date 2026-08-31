N = int(input())
A = [int(i) for i in input().split()]
maxA=max(A)
pn=list(range(maxA+1))
n=2
while n*n <= maxA:
  if n == pn[n]:
    for m in range(n, len(pn), n):
      if pn[m] == m:
        pn[m] = n
  n+=1

s=set()
for a in A:
  st = set()
  while a > 1:
    st.add(pn[a])
    a//=pn[a]
  if not s.isdisjoint(st):
    break
  s |= st
else:
  print("pairwise coprime")
  exit()

from math import gcd

n = gcd(A[0], A[1])
for a in A[2:]:
  n=gcd(n,a)
if n == 1:
  print("setwise coprime")
else:
  print("not coprime")
