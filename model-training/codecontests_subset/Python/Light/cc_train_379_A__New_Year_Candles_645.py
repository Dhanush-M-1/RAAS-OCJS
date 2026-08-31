a, b = input().split()
a = int(a)
b = int(b)
c = 0
sum = a
while a > 0:
	c += (a % b)
	a = int(a / b)
	if c >= b:
		a += int(c / b)
		c -= b
	sum += a
print (sum)