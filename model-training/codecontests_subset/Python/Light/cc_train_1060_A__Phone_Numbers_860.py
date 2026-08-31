n = int(input()) ; num = input()
a = n // 11 ; b = 0 ; p = 0
while p < len(num):
	x = num[p]
	if x == '8':
		b += 1
	p += 1
if b == 0:
	print(0)
else:
	if a > b:
		print(b)
	else:
		print(a)
