from math import ceil 
q = int(input())
for i in range(q):
  l, r, d = list(map(int, input().split()))
  x = d
  y = (r // d +1)* d
  s = min(x,y)
  if s >= l:
    print(max(x,y))
  else:
    print(s)