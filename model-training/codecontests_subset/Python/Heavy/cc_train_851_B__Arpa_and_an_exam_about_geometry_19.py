from sys import stdin, stdout

def readline():
    return stdin.readline().rstrip()

def writeline(s):
    stdout.write(str(s)+"\n")

from math import atan2, isclose, inf, sqrt
from decimal import Decimal

ax, ay, bx, by, cx, cy = [int(x) for x in readline().split()]

def dist(p, q):
    return sum(Decimal(px - qx) ** Decimal(2.0) for px, qx in zip(p, q))

def slope(x1, y1, x2, y2):
    dy = y2 - y1
    dx = x2 - x1
    return dy / dx if dx != 0 else inf

line = isclose(slope(ax, ay, bx, by), slope(bx, by, cx, cy)) 
distance = dist((ax, ay), (bx, by)) == dist((bx, by), (cx, cy))
result = not line and distance
writeline("Yes" if result else "No")