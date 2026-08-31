import math
n, x, y = map(int, input().split())

needed = (y/100 * n)

ans = math.ceil(max(0, needed-x))

print(ans)


