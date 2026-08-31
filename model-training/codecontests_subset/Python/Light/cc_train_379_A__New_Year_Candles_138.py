a, b = map(int, input().split())
burnt = 0
t = 0
while a > 0:
  t += a
  burnt += a
  a = burnt//b
  burnt = burnt % b
print(t)