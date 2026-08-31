from sys import stdin
n = int(input())
matrix = stdin.read().splitlines()
matrix = [bin(int(i, 16))[2:].zfill(n) for i in matrix]

# print(matrix)
dp = [[0] * (n + 1) for _ in range(n + 1)]
# dp[y][x] denotes the sum of rectangle of (0,0) -> (y-1,x-1)

for y in range(1, n + 1):
    for x in range(1, n + 1):
        dp[y][x] = dp[y - 1][x] + dp[y][x - 1] - dp[y - 1][x - 1] + (
            matrix[y - 1][x - 1] == '1')


def get_sum(sy, sx, ey, ex):
    return dp[ey][ex] - dp[ey][sx] - dp[sy][ex] + dp[sy][sx]


ans = 1
for x in range(n, 0, -1):
    if n % x == 0:
        flag = True
        for i in range(0, n, x):
            for j in range(0, n, x):
                temp = get_sum(i, j, i + x, j + x)
                if temp not in (x**2, 0):
                    flag = False
                    break
            if not flag:
                break
        if flag:
            ans = x
            break

print(ans)