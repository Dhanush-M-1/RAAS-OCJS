from collections import Counter

N = int(input())

A, B = ['a'], []
for i in range(1, N):
  for a in A:
    for c in 'abcdefghij'[:len(set(a))+1]:
      B.append(a + c)
  A, B = B, []

for a in A:
  print(a)