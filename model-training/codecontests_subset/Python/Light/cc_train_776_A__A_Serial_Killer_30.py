a, b = input().split()
n = int(input())

print(a, b)
for i in range(n):
	kill, ptn = input().split()
	if (kill == a):
		a = ptn
	else:
		b = ptn
	print(a, b)