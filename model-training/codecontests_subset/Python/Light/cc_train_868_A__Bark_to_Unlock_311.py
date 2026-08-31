password_m = str(input())
n = int(input())
list = []
list_1 = []
list_2 = []
for x in range(n):
	a = input()
	list.append(a)

if password_m in list:
	print("YES")

elif password_m[::-1] in list:
	print("YES")

else:
	if len(list) == 1:
		list.append(list[0])

	for x in range(len(list)):
		b = list[x]
		if b[1] == password_m[0]:
			list_1.append(1)
		elif b[0] == password_m[1]:
			list_2.append(1)
	if len(list_1) > 0 and len(list_2) > 0:
		print("YES")
	else:
		print("NO")