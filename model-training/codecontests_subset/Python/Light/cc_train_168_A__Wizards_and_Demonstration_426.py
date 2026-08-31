import math
n, x, y = map(int, input().split())
ans = max(0, math.ceil(y / 100 * n) - x)
print(ans)