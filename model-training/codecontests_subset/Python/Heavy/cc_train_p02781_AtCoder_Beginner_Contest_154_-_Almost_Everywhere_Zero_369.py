n = int(input())
k = int(input())

digit = len(str(n))
# dp[i桁まで検査済み][lessthan][0以外の個数]
dp = [[[0] * (k + 2) for i in range(2)] for j in range(digit + 1)]
dp[0][0][0] = 1

for a in range(1, digit + 1):
    digitvalue = int(str(n)[a - 1])
    for b in range(2):
        for c in range(k + 1):
            for d in range(10 if b == 1 else digitvalue + 1):
                dp[a][1 if b == 1 else 1 if (d < digitvalue) else 0][c if d == 0 else c + 1] += dp[a - 1][b][c]

print(dp[digit][0][k] + dp[digit][1][k])

