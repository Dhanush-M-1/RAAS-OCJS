from fractions import gcd

Q = int(input())
qs = []
for _ in range(Q):
	qs.append(list(map(int, input().split())))

for q in qs:
	a, b, c, d = q[0], q[1], q[2], q[3]
	if a < b or b > d:
		print("No")
	elif b <= c:
		print("Yes")
	elif d % b == 0:
		if a % b > c:
			print("No")
		else:
			print("Yes")
	else:
		a = a % b
		d = d % b
		d = gcd(b, d)
		if a > c:
			print("No")
		elif (a + ((c - a) // d) * d + d) % b <= c:
			print("Yes")
		else:
			print("No")