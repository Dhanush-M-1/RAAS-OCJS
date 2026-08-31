n = int(input())
x = [int(n) for n in input().split()]
n -= 1
y = [int(n) for n in input().split()]
n -= 1
z = [int(n) for n in input().split()]

hold = []
y1 = {}
for num in y:
	if(num not in y1):
		y1[num] = 1
	else:
		y1[num] = y1[num] + 1
for num in x:
	if num in y1:
		if y1[num] != 0:
			y1[num] -= 1
		else:
			hold.append(num)
	else:
		hold.append(num)

z1 = {}
for num in z:
	if(num not in z1):
		z1[num] = 1
	else:
		z1[num] = z1[num] + 1
for num in y:
	if num in z1:
		if z1[num] != 0:
			z1[num] -= 1
		else:
			hold.append(num)
	else:
		hold.append(num)

for num in hold:
	print(num)