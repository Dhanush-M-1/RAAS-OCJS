from math import ceil
x, y, percentage = map(int, input().split())
ans = percentage / 100 * x
if ans > y:
    print(ceil(ans - y))
else:
    print(0)