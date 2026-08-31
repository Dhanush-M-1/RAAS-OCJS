l = [0]*1000
n, m = map(int, input().split())
for _ in range(n):
  for x in map(int, input().split()[1:]):
    l[x] += 1
    if l[x] == 1:
      m -= 1
print("NO" if m else "YES")
  
  