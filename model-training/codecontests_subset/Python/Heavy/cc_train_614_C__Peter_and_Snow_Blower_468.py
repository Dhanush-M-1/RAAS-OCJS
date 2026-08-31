__author__ = 'Subirdcom'
from math import hypot
from math import pi
from math import acos
from math import degrees
from math import sqrt

def distance(x1, y1, x2, y2):
    return hypot(x1 - x2, y1 - y2)
def is_stupid(x1, y1, x2, y2, x3, y3):
    a = distance(x1, y1, x2, y2)
    b = distance(x2, y2, x3, y3)
    c = distance(x1, y1, x3, y3)
    return a ** 2 > b ** 2 + c ** 2 or c ** 2 > a ** 2 + b ** 2
def seg_dist(x, y, x1, y1, x2, y2):
    if is_stupid(x, y, x1, y1, x2, y2):
        return min(distance(x, y, x1, y1), distance(x, y, x2, y2))
    else:
        a = distance(x, y, x1, y1)
        b = distance(x1, y1, x2, y2)
        c = distance(x, y, x2, y2)
        p = (a + b + c) / 2
        s = sqrt(p * (p - a) * (p - b) * (p - c))
        return (2 * s) / b
n, px, py = [int(i) for i in input().split()]
x, y = [int(i) for i in input().split()]
lst = [[x, y]]
_min = distance(x, y, px, py)
_max = _min
for i in range(n - 1):
    x, y = [int(i) for i in input().split()]
    lst += [[x, y]]
    dist = distance(x, y, px, py)
    _max = max(_max, dist)
    _min = min(_min, dist)
for i in range(n - 1):
    _min = min(_min, seg_dist(px, py, lst[i][0], lst[i][1], lst[i + 1][0], lst[i + 1][1]))
_min = min(_min, seg_dist(px, py, lst[0][0], lst[0][1], lst[n - 1][0], lst[n - 1][1]))
print(pi * _max ** 2 - pi * _min ** 2)