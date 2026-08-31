def new_year_candles(c, d):
    x = c
    while c >= d:
        x += (c // d)
        c = (c// d) + (c % d)
    return x
# --------------------------------------------------------------
if __name__ == '__main__':
    f = lambda: map(int, input().split())
    a, b = f()
    print(new_year_candles(a,b))