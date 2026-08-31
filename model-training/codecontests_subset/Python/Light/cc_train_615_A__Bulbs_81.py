n, m = map(int, input().split())
s = []
for i in range(n):
  st = list(input().split())
  s += st[1:]
s = len(set(s))
if s >= m:
  print("YES")
else:
  print("NO")
  
