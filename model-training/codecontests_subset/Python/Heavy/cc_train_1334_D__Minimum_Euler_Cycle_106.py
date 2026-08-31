import sys
from collections import defaultdict
from copy import copy

R = lambda t = int: t(input())
RL = lambda t = int: [t(x) for x in input().split()]
RLL = lambda n, t = int: [RL(t) for _ in range(n)]

def solve():
  n, l, r = RL()
  if l == n*(n-1)+1:
    print(1)
    return
  l -= 1
  r -= 1
  D = ((2*n-1)**2-4*l)**.5
  a = (2*n-1-D)/2
  a = int(a)
  x = a*((n-1)+(n-a))
  l -= x
  r -= x
  i = 0
  s = []
  a += 1
  b = a + 1
  while i <= r and a < n:
    s += [str(a),str(b)]
    b += 1
    if b > n:
      a += 1
      b = a + 1
    i += 2
  s += "1"
  for c in s[l:r+1]:
    print(str(c),end = " ")
  print()

T = R()
for _ in range(T):
  solve()
