import sys
n, m = map(int, sys.stdin.readline().split())
ans = set()
for _ in range(n):
  alist = list(map(int, sys.stdin.readline().split()))
  for i in alist[1:]:
    ans.add(i)
if len(ans) == m:
  print('YES')
else:
  print('NO')
