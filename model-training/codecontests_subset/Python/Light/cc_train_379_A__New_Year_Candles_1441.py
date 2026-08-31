def candles(a, b):
    burnt_candles = a
    while a >= b:
        q, r = divmod(a, b)
        burnt_candles += q
        a = q + r
    return burnt_candles

if __name__ == '__main__':
    a, b = map(int, input().split())
    print(candles(a, b))