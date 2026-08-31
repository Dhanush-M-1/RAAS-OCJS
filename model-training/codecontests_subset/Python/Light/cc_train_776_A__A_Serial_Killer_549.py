a, b = input().split()
n = int(input())
print(a, b)
for i in range(n):
	c, d = input().split()
	if c==a:
		print(d, b)
		a = d
	elif c==b:
		print(d, a)
		b = d