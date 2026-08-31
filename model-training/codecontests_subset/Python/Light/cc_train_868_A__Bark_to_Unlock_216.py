si = input()
n = int(input())
s = set()
ans = 'NO'
while n:
  w = input()
  if w == si:
    ans = 'YES'
  s.add((w[0], 0))
  s.add((w[1], 1))
  n -= 1
if (si[0], 1) in s and (si[1], 0) in s:
  ans = 'YES'
print(ans)