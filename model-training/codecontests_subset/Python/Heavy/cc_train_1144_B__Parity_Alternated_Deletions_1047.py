n = int(input())

A = list(map(int, input().split()))


A.sort()

nodds = 0
nevens = 0
for i in range(len(A)):
  p1 = A[i] % 2
  if p1 == 1:
    nodds = nodds + 1
  if p1 == 0:
    nevens = nevens + 1

if nodds > nevens:
  startparity = 1
  nextparity = 0
  nodds -= 1
else:
  startparity = 0
  nextparity = 1
  nevens -= 1

# print(nodds, nevens)

for i in range(len(A)-1, -1, -1):
  if A[i] % 2 == startparity:
    A[i] = -1
    break

# print(nodds, nevens)

while (nextparity == 1 and nodds > 0) or \
      (nextparity == 0 and nevens > 0):
  # print(nodds,nev ens)
  for i in range(len(A)-1, -1, -1):
    if A[i] != -1 and A[i] % 2 == nextparity:
      A[i] = -1
      if nextparity == 1: nodds -= 1
      else: nevens -= 1
      nextparity = 1 - nextparity
      break

s = 0
for a in A:
  if a != -1: s += a

# print(A)
print(s)