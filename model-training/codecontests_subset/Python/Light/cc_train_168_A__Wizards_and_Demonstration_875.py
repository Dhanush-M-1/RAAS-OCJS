
from math import ceil
n, x, y = map(int, input().split())
required = ceil(y * n / 100)


print(max(0, required - x))