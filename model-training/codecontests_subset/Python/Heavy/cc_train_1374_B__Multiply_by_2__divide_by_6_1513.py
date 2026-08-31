def movesrequired(n):
	if n == 1:
		return 0
	x = n
	y = n
	count3 = 0
	while x > 2:
		if x%3 == 0:
			count3 += 1
			x = x//3
		else:
			break
	count2 = 0
	while y > 1:
		if y%2 == 0:
			count2 += 1
			y = y//2
		else:
			break
	
	m = (2**(count2))*(3**(count3))
	if n//m != 1:
		return -1
	if count2 > count3:
		return -1
	elif count3 > count2:
		return 2*count3 - count2 
	elif count3 == count3 and count3 != 0:
		return count3

t = int(input())
for _ in range(t):
	n = int(input())
	print(movesrequired(n))

