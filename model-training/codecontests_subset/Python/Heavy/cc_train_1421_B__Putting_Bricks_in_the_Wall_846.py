import typing
import sys
import math
import collections
import bisect
import itertools
import heapq
import decimal
# import numpy as np

# sys.setrecursionlimit(10000001)
INF = 10 ** 20
MOD = 10 ** 9 + 7
# MOD = 998244353


def ni(): return int(sys.stdin.buffer.readline())
def ns(): return map(int, sys.stdin.buffer.readline().split())
def na(): return list(map(int, sys.stdin.buffer.readline().split()))


# ===CODE===

def main():
    t = int(input())
    res = []
    for _ in range(t):
        n = int(input())
        for i in range(n):
            s = input().strip()
            if i == 0:
                a1 = s[1]
            if i == 1:
                a2 = s[0]
            if i == n-2:
                b2 = s[-1]
            if i == n-1:
                b1 = s[-2]


        if a1 == a2 and b1 == b2:
            if a1 != b1:
                res.append([0])
            else:
                res.append([2])
                res.append([1, 2])
                res.append([2, 1])
        elif a1 == a2 or b1 == b2:
            res.append([1])
            if a1 == a2:
                if b1 == a1:
                    res.append([n, n-1])
                else:
                    res.append([n-1, n])
            else:
                if a1 == b1:
                    res.append([1, 2])
                else:
                    res.append([2, 1])
        else:
            res.append([2])
            if a1 != "0":
                res.append([1, 2])
            if a2 != "0":
                res.append([2, 1])
            if b1 != "1":
                res.append([n, n-1])
            if b2 != "1":
                res.append([n-1, n])

    for ri in res:
        print(*ri, sep=" ")


if __name__ == '__main__':
    main()