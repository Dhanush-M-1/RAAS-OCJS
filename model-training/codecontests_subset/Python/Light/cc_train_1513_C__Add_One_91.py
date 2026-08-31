import sys
def get_ints(): return map(int, sys.stdin.readline().strip().split())

MOD = 10 ** 9 + 7
LIMIT = 20011
dp = []
for i in range(200011):
    if i < 10:
        dp.append(1)
    else:
        dp.append((dp[i - 9] + dp[i - 10]) % MOD)

T = int(input())
for _ in range(T):
    N, M = get_ints()
    ans = 0
    while N:
        ans = (ans + dp[N % 10 + M]) % MOD
        N //= 10
    print(ans)
