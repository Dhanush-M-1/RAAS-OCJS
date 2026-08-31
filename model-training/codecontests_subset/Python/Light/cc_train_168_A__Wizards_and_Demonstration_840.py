import math
n, x, y = map(int, input().split())
if n * y / 100 < x:
    print(0)
else:
    print(math.ceil(n * y / 100 - x))
