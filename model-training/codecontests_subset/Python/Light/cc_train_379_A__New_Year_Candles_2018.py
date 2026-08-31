"""379A: Новогодние свечки"""

str = input()
a = int(str.split(' ')[0])
b = int(str.split(' ')[1])

total = 0
ex = a
while a != 0:
	total += a
	a = ex // b
	ex = a + ex % b

print(total)