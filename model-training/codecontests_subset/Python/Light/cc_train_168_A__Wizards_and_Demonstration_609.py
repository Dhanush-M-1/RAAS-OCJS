from math import ceil
n, x, y = list(map(int, input().split()))
ans = float(y / 100) * n
if ((ceil(ans) - x) < 0):
    print(0)
else:
    print(ceil(ans) - x)