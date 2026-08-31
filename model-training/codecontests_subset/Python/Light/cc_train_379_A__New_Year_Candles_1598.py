import sys
a, b = map(int, sys.stdin.readline().split())
ans = a
rest = a
while rest >= b:
  ans += rest//b
  rest = rest//b + rest%b
print(ans)
