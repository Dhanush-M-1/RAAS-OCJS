from sys import stdin

input = stdin.readline
mxn = 2 * (10 ** 5) + 15
mod = 10 ** 9 + 7
dp = [1] * mxn

for i in range(10, mxn):
    dp[i] = (dp[i - 9] + dp[i - 10]) % mod

for test in range(int(input())):
    n, k = map(int, input().strip().split())
    ans = 0
    for i in str(n):
        ans = (ans + dp[k + int(i)]) % mod
    print(ans)
