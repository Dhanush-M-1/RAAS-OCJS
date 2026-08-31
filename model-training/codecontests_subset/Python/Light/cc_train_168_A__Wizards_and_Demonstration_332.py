import math
n , x, y = list(map(int, input().split()))
temp = math.ceil( (y/100) * n)

if temp - x >0:
	print(temp - x)
else:
	print(0)