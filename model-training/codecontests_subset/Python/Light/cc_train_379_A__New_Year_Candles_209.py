n, m = list(map(int, input().split()))
ans = 0
sr = 0
used = 0
new = n
while True:
  ans = ans + new
  used = new + sr
  if used < m:
    break
  new = used // m
  sr = used % m
print(ans)