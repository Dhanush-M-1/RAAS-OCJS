import math
x = input().split(" ")
y = math.ceil(((int(x[2])*int(x[0]))/100)-int(x[1]))
if y > 0:
	print(y)
else:
	print(0)