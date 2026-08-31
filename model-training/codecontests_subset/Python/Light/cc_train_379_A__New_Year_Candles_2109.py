a, b = map(int, input().strip().split())
s = a
while a > 0:
	if a < b:
		break
	temp = a%b
	a //= b
	s += a
	a += temp
print(s)