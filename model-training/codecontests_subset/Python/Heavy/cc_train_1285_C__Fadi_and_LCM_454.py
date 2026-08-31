def returnGCD(x, y):
	if y > x:
		return euclidean_algo(y, x)
	
	while y != 0:
		x, y = y, x % y
		
	return x
	
def factors(n):
	lst = []
	for i in range(1, int(n**0.5) + 1):
		if n % i == 0:
			lst.append([i, n//i])
	return lst


original = int(input())
facts=factors(original)
facts.sort()

currentlist = 0
current = 10000000000000000000000
for i in facts:
	a = max(i)
	if a < current and (i[0]*i[1])/returnGCD(i[1], i[0]) == original:
		currentlist = i
		current = a

print(currentlist[0], currentlist[1])
