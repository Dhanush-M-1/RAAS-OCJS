import math
n, x, y = map(int, input().split())

p = y * n / 100
t = math.ceil(p - x)
print(t if t >= 0 else 0)