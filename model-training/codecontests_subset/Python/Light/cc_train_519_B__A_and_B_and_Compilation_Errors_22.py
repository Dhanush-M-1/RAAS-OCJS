import sys
n = int(input())
alist = dict()
for i in range(3):
  alist[i] = sorted(list(map(int, sys.stdin.readline().split())))
for i in range(2):
  for j in range(n-i-1):
    if alist[i][j] != alist[i+1][j]:
      print(alist[i][j])
      break
  else:
    print(alist[i][-1])
