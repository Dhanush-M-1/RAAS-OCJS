def fr(a, b):
	if b == 0:
		return [1, 0, a]
	x, y, g = fr(b, a % b)
	return [y, x - (a // b) * y, g]
n, p, w, d = list(map(int, input().split()))
x0, y0, gc = fr(w, d)
if p % gc > 0:
	print('-1')
	raise SystemExit(0)
x0 *= (p // gc)
y0 *= (p // gc)
l = - 10 ** 30
r = 10 ** 30
while l < r - 1:
	k = (l + r) // 2
	if x0 + y0 + k * (d - w) // gc <= n:
		if x0 + d * k // gc >= 0 and y0 - w * k // gc >= 0:
			print(x0 + d * k // gc, end = ' ')
			print(y0 - w * k // gc, end = ' ')
			print(n - (x0 + y0 + k * (d - w) // gc))
			raise SystemExit(0)
		elif x0 + d * k // gc < 0:
			l = k
		else:
			r = k
	else:
		l = k
print('-1')
