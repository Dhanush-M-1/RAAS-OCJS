import sys

n, k, m = map(int, input().split())
a = list(map(int, input().split()))
total = sum(a)

if n * total <= m:
    print(n*(k+1))
    exit()

ans = 0

for complete in range(n):
    if complete*total > m:
        break

    items = a * (n - complete)
    dp = [-1]*(len(items)+1)
    dp[0] = m - complete * total

    for x in items:
        for i in range(len(items)-1, -1, -1):
            dp[i+1] = max(dp[i+1], dp[i]-x)

    for i in range(len(items), -1, -1):
        if dp[i] >= 0:
            ans = max(ans, i + complete * (k+1))
            break

print(ans)
