from math import ceil

n, x, y = (int(i) for i in input().split(' '))

z = ceil(n * y / 100)

if z > x:
    print(z - x)
else:
    print(0)
