akdmslac = int(input())
a = []
b = 0
d = 0
e = 0
c = 0
a = [int(x) for x in input().split()]
for i in range(akdmslac):
	if a[i] % 2 == 0:
		b = b + 1
	else:
		c = c + 1
if b - c == 1 or b - c == -1 or b == c:
	print("0")
else:
	if b > c:
		for n in range(akdmslac):
			if min(a) % 2 == 0:
				d = d + min(a)
				e = e + 1
			if e == (b - c - 1):
				break
			a.remove(min(a))
	elif c > b:
		for n in range(akdmslac):
			if min(a) % 2 == 1:
				d = d + min(a)
				e = e + 1
			if e == (c - b - 1):
				break
			a.remove(min(a))
	print(d)