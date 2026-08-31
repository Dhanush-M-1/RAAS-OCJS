#!/usr/bin/env python3
a, b = [int(x) for x in input().split()]

candles_off = a
nb_candles = a
while (candles_off > 0):
    if candles_off>=b:
        nb_candles += int(candles_off / b)
        candles_off = int(candles_off / b) + (candles_off % b)
    else:
        break

print(nb_candles)
