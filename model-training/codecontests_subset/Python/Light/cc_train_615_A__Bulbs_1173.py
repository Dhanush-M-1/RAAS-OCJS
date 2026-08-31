n, m = map(int, input().split())
s = set()
for _ in range(n):
   for c in list(map(int, input().split()))[1:]:
       s.add(c)
print("YES" if (len(s) == m) else "NO")