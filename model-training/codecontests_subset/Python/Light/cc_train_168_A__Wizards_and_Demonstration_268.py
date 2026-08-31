import math
n, x, y = map(int, input().split())
req = math.ceil(y/100 * n)
ans = req - x
if ans > 0:
    print(ans)
else:
    print(0)