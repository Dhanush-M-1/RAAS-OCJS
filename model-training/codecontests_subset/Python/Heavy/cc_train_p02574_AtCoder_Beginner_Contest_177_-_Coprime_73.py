import math
import sys
n = int(input())
a = list(map(int, input().split()))

ga = a[0]
for i in range(n):
  ga = math.gcd(ga, a[i])

if ga != 1:
  print("not coprime")
  sys.exit()

m = 1000000
b = [0]*(m+1)

for i in range(2, m):
  if b[i] != 0:
    continue
  j = 1
  while True:
    t = i * j
    if t > m:
      break
    if b[t] == 0:
      b[t] = i
    j += 1

d = {}
for i in a:
  p = i
  while p != 1:
    if p in d:
      print("setwise coprime")
      sys.exit()
    d[p] = 1
    p = int(p/b[p])
print("pairwise coprime")
