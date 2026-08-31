#!/usr/bin/python3
# -*- coding: utf-8 -*-

import math
import sys

def rl(proc=None):
    if proc is not None:
        return proc(sys.stdin.readline())
    else:
        return sys.stdin.readline().rstrip()

def srl(proc=None):
    if proc is not None:
        return list(map(proc, rl().split()))
    else:
        return rl().split()

INF = 10 ** 30

def dist(x1, y1, x2, y2):
    return ((x1-x2) * (x1-x2) + (y1-y2) * (y1-y2))

def dist2(x0, y0, x1, y1, x2, y2):
    x1 -= x0
    y1 -= y0
    x2 -= x0
    y2 -= y0
    dx = x2-x1
    dy = y2-y1
    a = - (x1 * dx + y1 * dy) / (dx * dx + dy * dy)
    if a < 0 or a > 1:
        return INF
    xt = x1 + a * dx
    yt = y1 + a * dy

    return xt * xt + yt * yt

def main():
    N, Px, Py = srl(int)
    A = [
        srl(int) for _ in range(N)
    ]
    mx = 0
    mn = INF
    for x, y in A:
        d = dist(Px, Py, x, y)
        mx = max(mx, d)
        mn = min(mn, d)
    mn = min(mn, dist2(Px, Py, A[0][0], A[0][1], A[-1][0], A[-1][1]))
    for i in range(1, len(A)):
        mn = min(mn, dist2(Px, Py, A[i][0], A[i][1], A[i-1][0], A[i-1][1]))
    print('%.9f' % (math.pi * (mx - mn)))

if __name__ == '__main__':
    main()
