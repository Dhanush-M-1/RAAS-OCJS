import math
import sys

sys.setrecursionlimit(1000)
n, x, y = map(int, input().split())
print(max(0, math.ceil(n * y / 100) - x))
