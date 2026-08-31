#https://codeforces.com/problemset/problem/379/A
#done

from sys import stdin

# a number of candles
# b make a new candle

a, b = [int(c) for c in stdin.readline().split()]



def re(candle, burnt_candle,time):
    time = time + candle
    burnt_candle = burnt_candle + candle
    candle = burnt_candle // b
    burnt_candle = burnt_candle - candle * b
    if candle > 0:
        return re(candle, burnt_candle, time)
    else:
        return time


print(re(a, 0, 0))