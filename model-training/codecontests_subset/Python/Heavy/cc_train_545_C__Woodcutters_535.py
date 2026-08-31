import math


def main():
    n = int(input())
    heights = [(-math.inf, 0)]
    for _ in range(n):
        x, h = map(int, input().split())
        heights.append((x, h))
    heights.append((math.inf, 0))
    dp = [[0, 0, 0] for _ in range(n + 1)]
    for i in range(1, n + 1):
        x, h = heights[i]
        x_prev, h_prev = heights[i - 1]
        x_next, h_next = heights[i + 1]
        if x - h > x_prev:
            if x - h > x_prev + h_prev:
                dp[i][1] = max(dp[i - 1]) + 1
            else:
                dp[i][1] = max(dp[i - 1][1], dp[i - 1][0]) + 1
        if x + h < x_next:
            dp[i][2] = max(dp[i - 1]) + 1
        dp[i][0] = max(dp[i - 1])
    print(max(dp[n]))


if __name__ == '__main__':
    main()
