l = input().split()
print(*l)
n = int(input())
for i in range(n):
  m, p = input().split()
  l.remove(m)
  l.append(p)
  print(*l)  