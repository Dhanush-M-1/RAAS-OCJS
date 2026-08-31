n,x,y = map(int, input().split())
from math import ceil
required = ceil(n*(y/100))
print(max(0, required - x))