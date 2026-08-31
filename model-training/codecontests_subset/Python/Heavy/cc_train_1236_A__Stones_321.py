cache = {}


def dp(a, b, c):
    if (a, b, c) in cache:
        return cache[(a, b, c)]
    if (a == 0 or b <= 1) and (b == 0 or c <= 1):
        result = 0
    else:
        if a == 0 or b <= 1:
            result = 3 + dp(a, b - 1, c - 2)
        elif b == 0 or c <= 1:
            result = 3 + dp(a - 1, b - 2, c)
        else:
            x1 = 3 + dp(a - 1, b - 2, c)
            x2 = 3 + dp(a, b - 1, c - 2)
            result = max(x1, x2)
    cache[(a, b, c)] = result
    return result


t = int(input())
for i in range(t):
    a, b, c = map(int, input().split())
    print(dp(a, b, c))
