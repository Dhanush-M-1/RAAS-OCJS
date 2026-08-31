def candles(big, small, t):
    if big > 0:
        return big + candles(0, small + big, t)
    if small < t:
        return 0
    return candles(small // t, small % t, t)

a, b = map(int, input().split())
print(candles(a, 0, b))

