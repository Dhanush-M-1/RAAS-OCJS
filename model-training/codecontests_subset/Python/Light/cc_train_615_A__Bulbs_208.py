def read(): return list(map(int, input().split()))
n, m = read()
s = []
for _ in range(n):
  s.extend(read()[1:])
print("YES" if len(set(s)) == m else "NO")