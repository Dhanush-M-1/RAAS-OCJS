import sys
input = sys.stdin.readline
t = int(input().strip())

M = 1000000007
dp = [0] * (2 * 100000+20)
dp[:10] = list(1 for i in range(10))
for i in range(10, 2*100000+20):
    dp[i] = dp[i-9] + dp[i-10]
    dp[i] %= M
while t:
    t -= 1
    n, m = map(int, input().strip().split())
    n = str(n)
    result = 0
    for i in n:
        result += dp[int(i)+m]
        result %= M
    print(result)
