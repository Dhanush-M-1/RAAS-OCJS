#!/usr/bin/env python3

def fun(a, b):
    periods = a // (b - 1)
    days = periods * b
    candles = periods * (b - 1)

    if a % (b - 1) == 0:
        return days - 1
    else:
        return days + (a - candles)

if __name__ == '__main__':
    a, b = map(lambda x: int(x), input().split(" "))
    print(fun(a, b))


