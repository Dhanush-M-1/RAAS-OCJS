def can_cut_left(C, H, i, n):
    # 1 <= i <= n
    return C[i - 1] < C[i] - H[i]

def can_cut_right(C, H, i, n):
    if i == n:
        return True
    return C[i] + H[i] < C[i + 1]

def can_cut_left_if_right(C, H, i, n):
    # 1 <= i <= n
    return C[i - 1] + H[i - 1] < C[i] - H[i]


def main():
    n = int(input())
    C = [0] * (n + 1)
    H = [0] * (n + 1)
    for i in range(1, n + 1):
        c, h = map(int, input().split())
        C[i] = c
        H[i] = h

    dp = [[0 for _ in range(3)] for _ in range(n + 1)]

    for j in range(3):
        dp[0][j] = 0

    dp[1][0] = 1
    dp[1][1] = 0
    dp[1][2] = 1 if can_cut_right(C, H, 1, n) else 0
    
    for i in range(2, n + 1):
        for j in range(3):
            # Left
            if j == 0:
                if can_cut_left(C, H, i, n):
                    # If the last tree was cutten to the right, we need to take care of an additional case.
                    if can_cut_left_if_right(C, H, i, n):
                        dp[i][j] = 1 + max(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2])
                    else:
                        dp[i][j] = 1 + max(dp[i - 1][0], dp[i - 1][1])
                else:
                    if can_cut_right(C, H, i - 1, n):
                        dp[i][j] = max(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2])
                    else:
                        dp[i][j] = max(dp[i - 1][0], dp[i - 1][1])
            elif j == 1:
                # Not cutting
                if can_cut_right(C, H, i - 1, n):
                    dp[i][j] = max(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2])
                else:
                    dp[i][j] = max(dp[i - 1][0], dp[i - 1][1])
            else:
                if can_cut_right(C, H, i, n):
                    dp[i][j] = 1 + max(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2])
                else:
                    dp[i][j] = max(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2])

    m = max(dp[n][0], dp[n][1], dp[n][2])
    print(m)


if __name__ == "__main__":
    main()