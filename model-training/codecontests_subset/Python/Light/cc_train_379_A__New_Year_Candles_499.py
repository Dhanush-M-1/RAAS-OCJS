ab = [int(x) for x in input().split()]
cura = ab[0]
curb = 0
count = 0
while cura > 0:
	count += cura
	curb += cura
	cura = curb // ab[1]
	curb = curb % ab[1]
print(count)