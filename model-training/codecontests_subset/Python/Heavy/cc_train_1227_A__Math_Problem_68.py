import os
import sys

DEBUG = 'DEBUG' in os.environ


def inp():
    return sys.stdin.readline().rstrip()


def Rint():
    return int(inp())


def Rints():
    return [int(e) for e in inp().split()]


# def dprint(*value, sep=' ', end='\n'):
#     if DEBUG:
#         print(*value, sep=sep, end=end)

##########################################


def main():
    n = Rint()
    res = [None, None]
    starts, ends = [], []

    for _ in range(n):
        seg = Rints()
        starts.append(seg[0])
        ends.append(seg[1])
    res[0] = max(starts)
    res[1] = min(ends)
    if res[1] < res[0]:
        return res[0] - res[1]
    else:
        return 0


for _ in range(Rint()):
    print(main())
