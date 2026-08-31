from math import ceil
n, x, y = map(int, input().split())
target = ceil(n*(y/100))
if target-x >0:
    print(target-x)
else:
    print(0)
