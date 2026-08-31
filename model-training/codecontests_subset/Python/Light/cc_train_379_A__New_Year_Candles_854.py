a, b = map(int, input().split())
res = a
h = 0
while a > 0:
	t = (a + h) // b
	h = (a + h) % b
	a = t
	res += a
print(res)
