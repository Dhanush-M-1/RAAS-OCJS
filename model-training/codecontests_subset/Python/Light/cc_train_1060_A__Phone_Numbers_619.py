n = 0
a = input()
b = list(input())

for element in b:
	if element == "8":
		n += 1

if len(b) < 11:
	print(0)
elif n < 1:
	print(0)
elif (len(b) // 11) == n:
	print(n)
elif (len(b) // 11) > n:
	print(n)
elif (len(b) // 11) < n:
	print(len(b) // 11)