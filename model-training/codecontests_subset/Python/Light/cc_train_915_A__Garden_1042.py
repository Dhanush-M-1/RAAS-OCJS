n, k = map(int, input().split())
a = list(map(int, input().split()))
ans = 100
for x in a:
  if k % x == 0:
    ans = min(ans, k // x)
print(ans)