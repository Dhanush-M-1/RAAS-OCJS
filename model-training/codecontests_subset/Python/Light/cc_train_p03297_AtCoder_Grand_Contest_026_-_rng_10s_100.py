from fractions import gcd
t = int(input())
for _ in range(t):
  a, b, c, d = map(int, input().split())
  if a - b < 0:
    print("No")
    continue
  if b > d:
    print("No")
    continue
  g = gcd(b, d)
  s = a + (c - a) // b * b
  if s < 0:
    print("No")
    continue
  #print((((b - s - 1) // g) * g + s) % b, s, g)
  if (((b - s - 1) // g) * g + s) % b > c: print("No")
  else: print("Yes")