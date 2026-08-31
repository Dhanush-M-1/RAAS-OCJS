import math
n, x, z = map(int, input().split())
print(max(0, math.ceil(n / 100 * z) - x))
