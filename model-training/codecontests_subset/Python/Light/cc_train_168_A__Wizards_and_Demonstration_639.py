n, x, y = map(int,input().split())
import math
print (0 if x>=n*y/100 else math.ceil(n*y/100 - x))