import sys

for j in range(int(input())):

	n, list1 = int(input()), []

	for i in range(n):
		z = [str(i) for i in sys.stdin.readline().strip()]
		list1.append(z)

	a1, a2, b1, b2 = list1[0][1], list1[1][0], list1[-1][-2], list1[-2][-1]

	if a2 == a1 and b2 == b1 and a2 != b2:
		print(0)

	elif a2 == a1 == b2 == b1:
		print(2)
		print(1, 2)
		print(2, 1)

	elif a2 != a1 and b1 == b2:
		print(1)
		if a1 != b1:
			print(2, 1)
		else:
			print(1, 2)

	elif a2 == a1 and b2 != b1:
		print(1)
		if a1 != b1:
			print(n - 1, n)
		else:
			print(n, n - 1)

	elif a2 != a1 and b1 != b2:

		print(2)
		if a1 != b1:
			print(1, 2)
			print(n, n - 1)
		else:
			print(1, 2)
			print(n - 1, n)