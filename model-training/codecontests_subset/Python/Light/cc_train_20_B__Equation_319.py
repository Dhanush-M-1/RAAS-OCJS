import math
A, B, C = input().split()
A, B, C = float(A), float(B), float(C)
if A == 0 and B == 0:
	if C == 0:
		print(-1)
	else:
		print(0)
elif A == 0:
	print(1)
	print("%.10f" % (-C / B))
else:
	det = B * B - 4 * A * C
	if det < 0:
		print(0)
	elif det == 0:
		print(1)
		x = -B / (2 * A)
		print("%.10f" % x)
	else:
		print(2)
		x1 = (-B + math.sqrt(det)) / (2 * A)
		x2 = (-B - math.sqrt(det)) / (2 * A)
		if x1 < x2:
			print("%.10f" % x1)
			print("%.10f" % x2)
		else:
			print("%.10f" % x2)
			print("%.10f" % x1)
