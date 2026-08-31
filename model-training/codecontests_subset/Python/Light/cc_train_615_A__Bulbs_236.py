n, m = map(int, input().split())
myset = set()
for _ in range(n):
  a = list(map(int, input().split()))
  myset.update(a[1:])
if len(myset) == m:
  print('YES')
else:
  print('NO')