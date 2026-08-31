import math
arr = input().split()
n = int(arr[0])
x = int(arr[1])
y = int(arr[2])

ans = ((n*y)/100) - x
if ans > 0:
	print(math.ceil(ans))
else:
	print('0')