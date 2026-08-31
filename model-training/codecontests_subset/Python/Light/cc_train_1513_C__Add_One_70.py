import sys
input = sys.stdin.readline
MOD = 1000000007
dp = [1 for _ in range(200010)]
for i in range(10, 200010):
    dp[i] = (dp[i-10]+dp[i-9]) % MOD

for _ in range(int(input())):
    n, m = map(int, input().split())
    ans = 0
    while n:
        ans += dp[m+n % 10]
        n //= 10
        ans %= MOD
    print(ans)
