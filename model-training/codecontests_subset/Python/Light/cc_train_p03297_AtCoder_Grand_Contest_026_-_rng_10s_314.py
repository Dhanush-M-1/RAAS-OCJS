def gcd(a,b):
  while b: a,b = b, a%b
  return a

t = int(input())
for _ in range(t):
  a, b, c, d = map(int, input().split())
  if a < b or d < b: print('No')
  elif c >= b: print('Yes')
  else:
    g = gcd(b,d)
    if b-g+a%g > c: print('No')
    else: print('Yes')
      