n = int(input())

s = input()

e = s.count('8')

a = 0

while e > 0 and n > 10:
	e -= 1
	n -= 11
	a += 1

print(a)
