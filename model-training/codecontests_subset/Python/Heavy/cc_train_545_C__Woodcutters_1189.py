# import collections as co
# import sys as sy
#
#
# def inp(n1):
#     if n1 == 1:
#         return map(int, sy.stdin.readline().split())
#     elif n1 == 2:
#         return map(float, sy.stdin.readline().split())
#     else:
#         return map(str, sy.stdin.readline().split())
#
#
# # I like dynamic programming
# def dp(i, pre):
#     if i >= n:
#         return 0
#
#     if mem[(i, pre)] != -1:
#         return mem[(i, pre)]
#
#     ans1, ans2, ans3, ret = 0, 0, 0, 0
#
#     if pre < (a[i][0] - a[i][1]):
#         ans1 = 1 + dp(i + 1, a[i][0])
#
#     if i == n - 1:
#         ans2 = 1 + dp(i + 1, a[i][0] + a[i][1])
#     if i < n - 1:
#         if (a[i][0] + a[i][1]) < a[i + 1][0]:
#             ans2 = 1 + dp(i + 1, a[i][0] + a[i][1])
#
#     ans3 = 0 + dp(i + 1, a[i][0])
#
#     ret = max(ans1, ans2, ans3)
#
#     mem[(i, pre)] = ret
#     return ret
#
#
# n = int(input())
# a, mem = [list(inp(1)) for i in range(n)], co.defaultdict(lambda: -1)
# print(dp(0, a[0][0] - a[0][1] - 1))

def main():
    n, ans = int(input()), 2
    a = [tuple(map(int, input().split())) for i in range(n)]
    last = a[0][0]
    ans = min(2, n)
    for i in range(1, n - 1):
        if a[i][0] - a[i][1] > last:
            ans += 1
            last = a[i][0]
        elif a[i][0] + a[i][1] < a[i + 1][0]:
            last = a[i][0] + a[i][1]
            ans += 1
        else:
            last = a[i][0]
    print(ans)


if __name__ == "__main__":
    main()
