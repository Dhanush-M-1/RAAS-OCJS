from sys import stdin
input = stdin.readline
def candle(a, b, c = 0):
    t = a
    while a >= b:
        while a:
            c += a % b
            a //= b
            t += a
        a = c
        c = 0
    return t
print(candle(*map(int, input().split())))
