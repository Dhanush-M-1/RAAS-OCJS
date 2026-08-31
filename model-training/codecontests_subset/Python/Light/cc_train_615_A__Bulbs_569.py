n, m = map(int, input().split())
s = set()
for i in range(n):
  a = list(map(int, input().split(" ")))
  s = s.union(a[1:])
print("YES" if len(s) == m else "NO")
