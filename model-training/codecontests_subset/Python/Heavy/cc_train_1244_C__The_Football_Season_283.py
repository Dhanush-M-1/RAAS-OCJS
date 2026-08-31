import math
import random

n, p, w, d = map(int, input().split())

output = []

c = (p - d * n) / (w - d)
c = math.ceil(c)

for b in range(d + 1):

	if (p - b * w) % d == 0:
		lower = (c - b) / d
		upper = (n - b) / d

		if lower > 0:
			a = math.ceil(lower)

		else:
			a = 0

		condition = True

		while condition == True:

			x = d * a + b

			if (p - x * w) >= 0:
				y = (p - x * w) / d

				if int(y) == y:
					y = int(y)
					z = n - x - y


					if z >= 0:
						output = [x, y, z]
						condition = False
			a += 1

			if a > upper:
				condition = False

	if len(output) == 3:
		
		if x + y + z == n: 
			print(x, y, z)
			break

else:
	print(-1)