a, b = map(int, input().split())
t = a
while a >= b:
	q = a//b
	r = a%b
	t += q
	a = q + r
print(t)