'''input
3 2
'''
a, b = map(int, input().split())
r = 0
t = 0
while a+r >= b:
	t += a
	r += a % b
	a //= b
	if r >= b:
		a, r = a + r//b, r % b

print(t+a)








