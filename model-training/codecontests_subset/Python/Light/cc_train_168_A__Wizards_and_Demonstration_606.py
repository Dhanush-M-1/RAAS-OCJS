import math

n, x, y = map(float, input().split())
required = math.ceil((n * y / 100) - x)
print(required if required >= 0 else 0)
