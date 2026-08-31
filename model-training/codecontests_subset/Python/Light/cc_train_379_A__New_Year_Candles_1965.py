
def candles(a, b):
    return (a-1) // (b-1) + a


if __name__ == '__main__':
    a, b = map(int, input().split())
    print(candles(a, b))