import math

n, x, y = map(int, input().split())

clones = math.ceil(n*y/100)-x

print(clones if clones > 0 else 0)
