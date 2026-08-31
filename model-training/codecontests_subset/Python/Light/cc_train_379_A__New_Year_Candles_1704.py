a, b = map(int, input().split(' '))

hours = a
wentOut = a
a = 0

while wentOut >= b:
	a = wentOut // b
	hours += a
	wentOut = wentOut % b + a

print(hours)


