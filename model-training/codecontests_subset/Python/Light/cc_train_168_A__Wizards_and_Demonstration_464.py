from math import ceil
n, x, y = map(int, input().split())
temp = ceil((y/100) * n)
print(max(temp-x, 0))