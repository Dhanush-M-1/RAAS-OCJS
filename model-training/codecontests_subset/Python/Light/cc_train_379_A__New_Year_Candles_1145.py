a, b = list(map(int, input().split()))


hours = 0
wornOut = 0

while a > 0:
	a -= 1
	wornOut += 1
	hours += 1
	if wornOut >= b:
		a += 1
		wornOut = 0
print(hours)