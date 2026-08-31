a, b = [int(x) for x in input().split()]

hours = 0
ctr = 0

while(a > 0):
	hours += 1
	a -= 1
	ctr += 1
	if ctr == b:
		ctr = 0
		a += 1

print(hours)