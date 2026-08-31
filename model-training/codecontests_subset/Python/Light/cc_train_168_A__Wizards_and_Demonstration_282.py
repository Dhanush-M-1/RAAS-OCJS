
import math
n, x, y = map(int, input().split())

# n * y / 100 = x + c

c = math.ceil(n * y / 100) - x
if c < 0:
	c = 0
print (c)
