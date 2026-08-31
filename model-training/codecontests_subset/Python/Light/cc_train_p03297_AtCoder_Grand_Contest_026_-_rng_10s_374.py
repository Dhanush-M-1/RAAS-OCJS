from fractions import gcd

t = int(input())
abcdt = [list(map(int, input().split())) for _ in range(t)]

for a, b, c, d in abcdt:
  if a < b:
    print('No')
  elif d < b:
    print('No')
  else:
    if d - b != 0:
      g = gcd(b, d - b)
    else:
      g = b
    if (a - c - 1) // g >= - ((-(a - b + 1)) // g):
      print('No')
    else:
      print('Yes')