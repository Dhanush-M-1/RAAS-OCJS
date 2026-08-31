
a, b = map(int, input().split())

t = 0
t += a
while a >= b:
	n = a % b
	a //= b
	
	t += a
	a += n

print(t)