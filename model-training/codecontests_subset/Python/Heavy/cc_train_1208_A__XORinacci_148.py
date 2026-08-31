import sys 
from collections import defaultdict
input = lambda : sys.stdin.readline().rstrip()

for t in range(int(input())):
  a, b, n = input().split()
  a, b = bin(int(a))[2:], bin(int(b))[2:]
  n = int(n)
  n += 1

  m = max(len(a), len(b))

  ans = ""
  for i, j in zip(a.zfill(m), b.zfill(m)):
    if i == j == '0':
      ans += '0'
    elif i == '0' and j == '1':
      ans += '101'[n%3]
    elif i == '1' and j == '0':
      ans += '110'[n%3]
    else:
      ans += '011'[n%3]
  
  if n == 1:
    print(int(a, 2))
  elif n == 2:
    print(int(b, 2))
  else:
    print(int(ans, 2))
