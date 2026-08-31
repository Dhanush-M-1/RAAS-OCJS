def good(n, k, p, a, b, x):
    j = 0
    c = 0
    for i in range(n):
        while j < k:
            if abs(a[i] - b[j]) + abs(b[j] - p) <= x:
                j += 1
                c += 1
                break
            j += 1
    return c == n

n, k, p = [int(x) for x in input().split(' ')]
a = [int(x) for x in input().split(' ')]
b = [int(x) for x in input().split(' ')]
a.sort()
b.sort()


l = -1
r = 2 * 10 ** 9
'''
while r - l > 1:
    m = (l + r) // 2
    if good(n, k, p, a, b, m):
        r = m
    else:
        l = m
print(r)
'''
dp = [[float('inf')] * (n + 1) for i in range(k + 1)]
dp[0][0] = 0

for i in range(k):
    for j in range(n + 1):
        dp[i + 1][j] = min(dp[i + 1][j], dp[i][j])
        if j < n:
            dp[i + 1][j + 1] = min(dp[i + 1][j + 1], max(dp[i][j], abs(a[j] - b[i]) + abs(b[i] - p)))

print(dp[k][n])
