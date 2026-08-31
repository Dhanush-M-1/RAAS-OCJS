a, b = map(int, input().split())
s, p = 0, 0
while(a > 0):
  s += 1
  p += 1
  a -= 1
  if p == b:
    p = 0
    a += 1
print(s)