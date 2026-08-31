import copy
k = int(input())
ans = ["a"]
for i in range(k-1):
  b = []
  for j in ans:
    t = max(j)
    for m in range(ord(t) - ord("a")+2):
      b.append(j + chr((ord("a")+m)))
  ans = b
for i in ans:
  print(i)