a, b = map(int, input().split())
c = 0
while a >= b:
	c += b
	a -= b
	a += 1
print(a + c)