import sys
import io, os

input = sys.stdin.readline

n, k = list(map(int, input().split()))
ranges = []
mod = 998244353

den = 1
num = 1
for i in range(k - 1):
    den = (den * (i + 1)) % mod
    num = num * (k - i) % mod
dp = {}
dp[0] = 1
divisor = 1
for j in range(1, n + 1):
    dp[j] = (dp[j - 1]  % mod * j) % mod
    divisor += 1
# print(dp)
for _ in range(n):
    l, r = list(map(int, input().split()))
    ranges.append(l * 2)
    ranges.append(r * 2 + 1)
ranges.sort()
cnt = 0
total = 0
for i in range(0, len(ranges)):
    if ranges[i] % 2 == 0:
        if cnt >= k - 1:
            total = (total +(dp[cnt]*pow(dp[k-1]*dp[cnt-(k-1)]%mod,mod-2,mod))) % mod
        cnt += 1
    else:
        cnt -= 1
print(total % mod)
