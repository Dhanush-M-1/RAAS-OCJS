'''input
icm codeforces
1
codeforces technex
'''
a, b = input().split()
n = int(input())
for _ in range(n):
	print(a, b)
	x, y = input().split()
	if a == x:
		a = y
	else:
		b = y
print(a, b)








