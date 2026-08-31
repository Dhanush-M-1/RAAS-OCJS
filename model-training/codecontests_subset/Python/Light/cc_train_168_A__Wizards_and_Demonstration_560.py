n, x, y = map(int,input().split())
import math
if x >= n*y/100:
    print(0)
else:
    print(math.ceil(n*y/100 - x))

