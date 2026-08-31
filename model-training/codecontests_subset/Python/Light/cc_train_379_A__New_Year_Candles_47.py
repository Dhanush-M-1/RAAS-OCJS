from math import *
a, b = map(int, input().split())
print(floor(a * (1 / (1 - 1 / b)) - 1e-5))