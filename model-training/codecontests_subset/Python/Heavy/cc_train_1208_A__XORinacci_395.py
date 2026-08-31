import sys


# def cal(a, b, n):
#     if n == 0:
#         return a
#     elif n == 1:
#         return b
#     else:
#         return cal(a, b, n-1) ^ cal(a, b, n-2)


# def cal(n):
#     if n == 0:
#         return dp[0]
#     elif n == 1:
#         return dp[1]
#     else:
#         dp.append(cal(n - 1) ^ cal(n - 2))
#     return dp[n]

if __name__ == '__main__':
    for t in range(int(input())):
        a, b, n = map(int, input().split())
        # dp = [a, b]
        #
        # for i in range(2, n+1):
        #     dp.append(dp[i-1] ^ dp[i-2])
        #
        # print(dp[n])

        mod_val = n % 3
        if mod_val == 0:
            print(a)
        elif mod_val == 1:
            print(b)
        else:
            print(a^b)





