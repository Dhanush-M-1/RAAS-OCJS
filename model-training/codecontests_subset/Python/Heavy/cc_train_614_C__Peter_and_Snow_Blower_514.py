#!/usr/bin/env python3

import math

def get_square(a, b, c):
    p = (a + b + c) * .5
    return math.sqrt(p * (p - a) * (p - b) * (p - c))

def get_angle(x1, y1, x2, y2, x3, y3):
    a1 = math.atan2(y1 - y2, x1 - x2)
    a2 = math.atan2(y3 - y2, x3 - x2)
    d = abs(a1 - a2)
    if d >= math.pi:
        return 2 * math.pi - d
    return d

try:
    while True:
        n, cx, cy = map(int, input().split())
        nd = 1e10
        fd = -1
        points = [ ]
        for i in range(n):
            x, y = map(int, input().split())
            d = math.hypot(x - cx, y - cy)
            points.append((x, y, d))
            nd = min(nd, d)
            fd = max(fd, d)
        for i, (x, y, a) in enumerate(points):
            px, py, b = points[i - 1]
            c = math.hypot(x - px, y - py)
            if a + b > c and a + c > b and b + c > a:
                h = 2 * get_square(a, b, c) / c
                a1 = get_angle(x, y, px, py, cx, cy)
                a2 = get_angle(px, py, x, y, cx, cy)
                if a1 <= math.pi * .5 and a2 <= math.pi * .5:
                    nd = min(nd, h)
                    # fd = max(fd, h)
        print("%.7f" % (math.pi * (fd - nd) * (fd + nd)))

except EOFError:
    pass
