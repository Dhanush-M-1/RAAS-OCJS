import sys

n, k = map(int, input().split())
a = list(map(int, input().split()))
ans = 10**9
for x in a:
    if k % x == 0:
        ans = min(ans, k // x)
print(ans)
