a, b = map(int, input().split())

s = a
while a >= b:
	s += a // b
	a -= (a // b) * b - a // b

print(s)
