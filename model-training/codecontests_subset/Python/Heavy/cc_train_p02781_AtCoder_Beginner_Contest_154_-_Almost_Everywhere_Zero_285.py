def main():
    S = input()
    N = len(S)
    K = int(input())
    dp = [[[0]*5 for j in range(2)] for i in range(N+1)]
    dp[0][0][0] = 1
    for i in range(N):
        for j in range(2):
            for k in range(4):
                lim = (9 if j else int(S[i]))
                for d in range(lim + 1):
                    # print(i, j, lim, d, j or d < lim)
                    dp[i+1][j or d < lim][k + int(d != 0)] += dp[i][j][k]
    print((dp[N][0][K]+dp[N][1][K]))


if __name__ == '__main__':
    main()
