[n, m] = [int(a) for a in input().split(" ")]

d = 1

while n > 0:
	n = n - 1
	
	if d % m == 0:
		n += 1
	d += 1
print (d - 1)
