#region Header
#!/usr/bin/env python3
# from typing import *

import sys
import io
import math
import collections
import decimal
import itertools
import bisect
import heapq


def input():
    return sys.stdin.readline()[:-1]


# sys.setrecursionlimit(1000000)
#endregion

# _INPUT = """4
# 3
# 1 4 2
# 1 3 1
# 2
# 2 4
# 2 3
# 2
# 1 1000000000
# 1 1000000000
# 4
# 3 10 5 8
# 2 5 2 4

# """
# sys.stdin = io.StringIO(_INPUT)


def solve(N, R, C):
    L = [(R[i], C[i]) for i in range(N)]
    L.sort()
    if L[0] != (1, 1):
        L = [(1, 1)] + L

    n = 0
    for i in range(len(L)-1):
        r1, c1 = L[i]
        r2, c2 = L[i+1]
        if (r1-c1)//2 == (r2-c2)//2:
            if (r2-c2) % 2 == 0:
                n += r2 - r1
        else:
            n += abs((r1-c1)//2 - (r2-c2)//2)
    return n

def main():
    T0 = int(input())
    for _ in range(T0):
        N = int(input())
        R = list(map(int, input().split()))
        C = list(map(int, input().split()))
        ans = solve(N, R, C)
        print(ans)

if __name__ == '__main__':
    main()
