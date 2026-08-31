import sys
import math

n, x, y = [int(x) for x in (sys.stdin.readline()).split()]

req = int(math.ceil(y / 100.0 * n))

if(req - x < 0):
    print(0)
else:
    print(req - x)