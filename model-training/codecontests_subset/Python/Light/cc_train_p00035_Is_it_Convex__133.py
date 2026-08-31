# -*- coding: utf-8 -*-

import sys
import os
import math


def cross(v1, v2):
    return v1[0] * v2[1] - v1[1] * v2[0]

def sign(v):
    if v >= 0:
        return 1
    else:
        return -1

for s in sys.stdin:
    ax, ay, bx, by, cx, cy, dx, dy = map(float, s.split(','))

    AB = (bx - ax, by - ay)
    BC = (cx - bx, cy - by)
    CD = (dx - cx, dy - cy)
    DA = (ax - dx, ay - dy)

    c0 = cross(AB, BC)
    c1 = cross(BC, CD)
    c2 = cross(CD, DA)
    c3 = cross(DA, AB)

    if sign(c0) == sign(c1) == sign(c2) == sign(c3):
        print('YES')
    else:
        print('NO')