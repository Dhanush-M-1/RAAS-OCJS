
from math import ceil
n, x, y = map(int, input().split())

goal = ceil(n * (y / 100))
print (max(goal - x, 0))