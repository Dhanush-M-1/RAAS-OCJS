
ab = input().split()
a = int(ab[0])
b = int(ab[1])

def totCandles(a, b):
	tot = a
	rem = 0
	while(a >= b):
		newCandle = int(a / b)
		tot = tot + newCandle
		rem = rem + (a % b)
		a = newCandle
	rem = rem + a
	# for remains
	while rem >= b:
		more = int(rem / b)
		tot = tot + more
		rem = more + (rem % b)
	return tot

total = totCandles(a, b)
print(total)