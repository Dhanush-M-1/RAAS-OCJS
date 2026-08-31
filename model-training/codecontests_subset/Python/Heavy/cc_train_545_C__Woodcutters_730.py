n = int(input())
x = [0] * n
h = [0] * n
dp = [0] * n

def task():
    global n, x, h, dp
    pos = 0
    for dx in range(n):
        if dx == n - 1:
            dp[dx] = dp[dx - 1] + 1
        else:
            dp[dx] = dp[dx - 1]
            if x[dx] - pos > h[dx] or dx == 0:
                dp[dx] += 1
                pos = x[dx]
            elif x[dx] + h[dx] < x[dx + 1]:
                dp[dx] += 1
                pos = x[dx] + h[dx]
            else:
                pos = x[dx]


def main():
    for i in range(n):
        global x, h
        x[i], h[i] = map(int, input().split(' '))
    task()
    print(dp[n - 1])


main()
