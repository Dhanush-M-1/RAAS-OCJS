from fractions import gcd
_, *Q = map(int, open(0).read().split())
for a, b, c, d in zip(*[iter(Q)] * 4):
	if a < b or d < b:
		print("No")
		continue
	if c >= b:
		print("Yes")
		continue
	a %= b
	g = gcd(b, d)
	# b - g + a - g * (a // g) < b
	if b - g + a - g * (a // g) > c:
		print("No")
	else:
		print("Yes")