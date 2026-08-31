#!/usr/bin/python3

def readln(): return tuple(map(int, input().split()))

from math import ceil
n, x, y = readln()
print(max(0, ceil(n * y / 100) - x))
