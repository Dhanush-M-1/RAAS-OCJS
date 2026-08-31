#!/usr/bin/env python3
"""
CodeForces
379 A. New Year Candles
http://codeforces.com/problemset/problem/379/A

@author yamaton
@date 2015-07-28
"""


def solve(candle, b):
    remaining = 0
    cnt = 0
    while candle:
        cnt += candle
        nxt_candle = (candle + remaining) // b
        remaining = (candle + remaining) % b
        candle = nxt_candle
    return cnt


def main():
    a, b = [int(i) for i in input().split()]
    result = solve(a, b)
    print(result)


if __name__ == '__main__':
    main()
