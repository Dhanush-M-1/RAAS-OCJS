import math
n, x, y = [int(s) for s in input().split(' ')]

c = max(math.ceil(n * (y / 100) - x), 0)
print(c)